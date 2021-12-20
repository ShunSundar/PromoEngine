package org.example.promotionengine.algorithm.discount;

import org.example.promotionengine.models.CartItem;
import org.example.promotionengine.models.PromotionItem;

import java.math.BigDecimal;

public interface DiscountCalculator {
    BigDecimal getPromotionDiscount(CartItem cartItem, PromotionItem promotionItem);
}
