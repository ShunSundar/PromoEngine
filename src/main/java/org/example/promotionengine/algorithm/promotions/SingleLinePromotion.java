package org.example.promotionengine.algorithm.promotions;

import org.example.promotionengine.algorithm.discount.DiscountCalculator;
import org.example.promotionengine.algorithm.discount.DiscountCalculatorFactory;
import org.example.promotionengine.models.Cart;
import org.example.promotionengine.models.CartItem;
import org.example.promotionengine.models.PromotionItem;
import org.example.promotionengine.models.SkuId;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class SingleLinePromotion implements PromotionAlgorithm{

    private final DiscountCalculatorFactory discountCalculatorFactory;

    public SingleLinePromotion(DiscountCalculatorFactory discountCalculatorFactory) {
        this.discountCalculatorFactory = discountCalculatorFactory;
    }

    @Override
    public boolean isValid(Cart cart, PromotionItem promotionItem) {
        SkuId productId = promotionItem.getProductIds().get(0);
        int promotionQuantity = promotionItem.getQuantity();
        return cart.getCartItem()
                .stream()
                .anyMatch(cartItem -> productId == cartItem.getProduct().getProductId() &&
                        !cartItem.isPromoApplied() &&
                        cartItem.getQuantity() >= promotionQuantity
                        );
    }

    @Override
    public void updatePromotionDiscount(Cart cart, PromotionItem promotionItem) {
        SkuId productId = promotionItem.getProductIds().get(0);
        int promotionQuantity = promotionItem.getQuantity();
        List<CartItem> cartItemList = cart.getCartItem()
                .stream()
                .filter(cartItem -> productId == cartItem.getProduct().getProductId() && !cartItem.isPromoApplied() && cartItem.getQuantity() >= promotionQuantity)
                .collect(Collectors.toList());
        BigDecimal cartLineItemDiscount = BigDecimal.ZERO;
        if(!cartItemList.isEmpty()) {
            for(CartItem cartItem : cartItemList) {
                BigDecimal cartItemPromotionDiscount = BigDecimal.ZERO;
                int cartItemQuantity = cartItem.getQuantity();

                while (cartItemQuantity >=promotionQuantity) {
                    DiscountCalculator discountCalculator = discountCalculatorFactory.getDiscountCalculator(promotionItem);
                    BigDecimal promotionDiscount = discountCalculator.getPromotionDiscount(cartItem,promotionItem);
                    cartItemPromotionDiscount = cartItemPromotionDiscount.add(promotionDiscount);
                    cartItemQuantity = cartItemQuantity-promotionQuantity;
                }

                if(cartItemPromotionDiscount.compareTo(BigDecimal.ZERO) > 0) {
                    cartItem.setPromoApplied(true);
                    cartItem.setLineItemPromotionDiscount(cartItemPromotionDiscount);
                    cartLineItemDiscount = cartLineItemDiscount.add(cartItemPromotionDiscount);
                    BigDecimal cartItemAmount = BigDecimal.ZERO;
                    if(cartItemQuantity > 0) {
                        cartItemAmount = cartItem.getProduct()
                                .getProductPrice()
                                .multiply(BigDecimal.valueOf(cartItemQuantity));
                    }
                    cartItemAmount = cartItemAmount.add(cartLineItemDiscount);
                    cartItem.setCartItemAmount(cartItemAmount);
                }
            }
        }

    }
}
