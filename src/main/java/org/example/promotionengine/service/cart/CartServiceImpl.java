package org.example.promotionengine.service.cart;

import org.example.promotionengine.models.Cart;
import org.example.promotionengine.models.CartItem;
import org.example.promotionengine.models.Product;
import org.example.promotionengine.models.PromotionItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService{
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
        return null;
    }
}
