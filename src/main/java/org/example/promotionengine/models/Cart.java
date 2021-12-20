package org.example.promotionengine.models;

import java.math.BigDecimal;
import java.util.List;

public class Cart {
    private List<CartItem> cartItem;
    private BigDecimal totalAmount;

    public Cart() {

    }

    public Cart(List<CartItem> cartItem,BigDecimal totalAmount) {
        this.cartItem = cartItem;
        this.totalAmount = totalAmount;
    }

    public List<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(List<CartItem> cartItem) {
        this.cartItem = cartItem;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}