package org.example.promotionengine.models;

import java.math.BigDecimal;

public class CartItem {

    private Product product;
    private int quantity;
    private BigDecimal cartItemAmount;
    private boolean isPromoApplied;
    private BigDecimal lineItemPromotionDiscount;


    public CartItem(Product product,int quantity,BigDecimal cartItemAmount,boolean isPromoApplied ,BigDecimal lineItemPromotionDiscount) {
        this.product = product;
        this.quantity = quantity;
        this.cartItemAmount = cartItemAmount;
        this.isPromoApplied = isPromoApplied;
        this.lineItemPromotionDiscount = lineItemPromotionDiscount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCartItemAmount() {
        return cartItemAmount;
    }

    public void setCartItemAmount(BigDecimal cartItemAmount) {
        this.cartItemAmount = cartItemAmount;
    }

    public boolean isPromoApplied() {
        return isPromoApplied;
    }

    public void setPromoApplied(boolean promoApplied) {
        isPromoApplied = promoApplied;
    }

    public BigDecimal getLineItemPromotionDiscount() {
        return lineItemPromotionDiscount;
    }

    public void setLineItemPromotionDiscount(BigDecimal lineItemPromotionDiscount) {
        this.lineItemPromotionDiscount = lineItemPromotionDiscount;
    }
}