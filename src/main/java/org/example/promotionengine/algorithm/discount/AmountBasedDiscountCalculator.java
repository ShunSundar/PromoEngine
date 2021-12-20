package org.example.promotionengine.algorithm.discount;

import org.example.promotionengine.models.CartItem;
import org.example.promotionengine.models.PromotionItem;

import java.math.BigDecimal;

public class AmountBasedDiscountCalculator implements DiscountCalculator{
    @Override
    public BigDecimal getPromotionDiscount(CartItem cartItem, PromotionItem promotionItem) {
        if(promotionItem != null &&
                promotionItem.getPromotionAmount().compareTo(BigDecimal.ZERO) > 0) {
            return promotionItem.getPromotionAmount();
        } else {
            return BigDecimal.ZERO;
        }
    }
}
