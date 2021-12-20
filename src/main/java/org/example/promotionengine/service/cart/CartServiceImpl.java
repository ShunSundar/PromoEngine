package org.example.promotionengine.service.cart;

import org.example.promotionengine.algorithm.promotions.PromotionAlgorithm;
import org.example.promotionengine.algorithm.promotions.PromotionAlgorithmFactory;
import org.example.promotionengine.models.Cart;
import org.example.promotionengine.models.CartItem;
import org.example.promotionengine.models.Product;
import org.example.promotionengine.models.PromotionItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService{

    private final PromotionAlgorithmFactory promotionAlgorithmFactory;

    public CartServiceImpl(PromotionAlgorithmFactory promotionAlgorithmFactory) {
        this.promotionAlgorithmFactory = promotionAlgorithmFactory;
    }

    @Override
    public void addToCart(Cart cart, CartItem cartItem) {
        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(cartItem);
        cart.setCartItem(cartItemList);
        cart.setTotalAmount(cart.getTotalAmount().add(cartItem.getCartItemAmount()));
    }

    @Override
    public CartItem createCartItem(Product product, int quantity) {
        return new CartItem(product,quantity,product.getProductPrice().multiply(BigDecimal.valueOf(quantity)),false,BigDecimal.ZERO);
    }

    @Override
    public Cart createCart() {
        return new Cart(new ArrayList<>(),BigDecimal.ZERO);
    }

    @Override
    public Cart updatePromotion(Cart cart, List<PromotionItem> promotionItemList) {
        promotionItemList.forEach(promotionItem -> {
            PromotionAlgorithm promotionAlgorithm = promotionAlgorithmFactory.getPromotionAlgorithm(promotionItem);
            if(promotionAlgorithm.isValid(cart,promotionItem)) {
                promotionAlgorithm.updatePromotionDiscount(cart,promotionItem);
            }
        });
        BigDecimal cartTotal = cart.getCartItem()
                .stream()
                .map(CartItem::getCartItemAmount)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        cart.setTotalAmount(cartTotal);
        return cart;
    }
}
