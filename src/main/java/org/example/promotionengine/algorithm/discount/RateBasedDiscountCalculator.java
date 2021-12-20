package org.example.promotionengine.algorithm.discount;

import org.example.promotionengine.models.CartItem;
import org.example.promotionengine.models.Product;
import org.example.promotionengine.models.PromotionItem;

import java.math.BigDecimal;
import java.math.MathContext;

public class RateBasedDiscountCalculator implements DiscountCalculator{
    private static final MathContext MATH_CONTEXT = new MathContext(4);
    @Override
    public BigDecimal getPromotionDiscount(CartItem cartItem, PromotionItem promotionItem) {
        if(cartItem != null && promotionItem != null && promotionItem.getPromotionAmount().compareTo(BigDecimal.ZERO) > 0) {
            Product product = cartItem.getProduct();
            BigDecimal productPrice = product.getProductPrice();
            BigDecimal rate = promotionItem.getPromotionAmount();
            return productPrice.multiply(rate.divide(BigDecimal.valueOf(100),MATH_CONTEXT));
        } else {
            return BigDecimal.ZERO;
        }
    }
}
