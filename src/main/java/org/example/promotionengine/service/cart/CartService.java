package org.example.promotionengine.service.cart;

import org.example.promotionengine.models.Cart;
import org.example.promotionengine.models.CartItem;
import org.example.promotionengine.models.Product;
import org.example.promotionengine.models.PromotionItem;

import java.util.List;

public interface CartService {
    void addToCart(Cart cart, CartItem cartItem);
    CartItem createCartItem(Product product,int quantity);
    Cart createCart();
    Cart updatePromotion(Cart cart, List<PromotionItem> promotionItemList);
}
