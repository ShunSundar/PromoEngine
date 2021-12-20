package org.example.promotionengine.algorithm.promotions;

import org.example.promotionengine.algorithm.discount.DiscountCalculator;
import org.example.promotionengine.algorithm.discount.DiscountCalculatorFactory;
import org.example.promotionengine.models.Cart;
import org.example.promotionengine.models.CartItem;
import org.example.promotionengine.models.PromotionItem;
import org.example.promotionengine.models.SkuId;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BundlePromotion implements PromotionAlgorithm{

    private static final MathContext MATH_CONTEXT = new MathContext(4);

    private final DiscountCalculatorFactory discountCalculatorFactory;

    public BundlePromotion(DiscountCalculatorFactory discountCalculatorFactory) {
        this.discountCalculatorFactory = discountCalculatorFactory;
    }

    @Override
    public boolean isValid(Cart cart, PromotionItem promotionItem) {
        List<SkuId> productIds = promotionItem.getProductIds();
        int promotionQuantity = promotionItem.getQuantity();
        boolean isApplicable = false;
        for(SkuId productId:productIds) {
            isApplicable = cart.getCartItem()
                    .stream()
                    .anyMatch(cartItem -> productId == cartItem.getProduct().getProductId()
                            && promotionQuantity == cartItem.getQuantity());
        }
        return isApplicable;
    }

    @Override
    public void updatePromotionDiscount(Cart cart, PromotionItem promotionItem) {
        List<SkuId> productIds = promotionItem.getProductIds();
        int promotionQuantity = promotionItem.getQuantity();
        DiscountCalculator discountCalculator = discountCalculatorFactory.getDiscountCalculator(promotionItem);
        BigDecimal promotionDiscount = discountCalculator.getPromotionDiscount(null,promotionItem);
        if(promotionDiscount.compareTo(BigDecimal.ZERO) > 0) {
            List<CartItem> cartItemList = cart.getCartItem()
                    .stream()
                    .filter(cartItem -> productIds.contains(cartItem.getProduct().getProductId()) && promotionQuantity == cartItem.getQuantity() &&
                                    !cartItem.isPromoApplied())
                    .collect(Collectors.toList());
            BigDecimal lineLevelPromotionDiscount = promotionDiscount.divide(BigDecimal.valueOf(cartItemList.size()),MATH_CONTEXT);
            IntStream.range(0,cartItemList.size())
                    .forEach(i -> {
                        CartItem cartItem = cartItemList.get(i);
                        cartItem.setPromoApplied(true);
                        cartItem.setLineItemPromotionDiscount(lineLevelPromotionDiscount);
                        if(i == cartItemList.size()-1) {
                            cartItem.setCartItemAmount(promotionDiscount);
                        } else {
                            cartItem.setCartItemAmount(BigDecimal.ZERO);
                        }
                    });
        }
    }
}