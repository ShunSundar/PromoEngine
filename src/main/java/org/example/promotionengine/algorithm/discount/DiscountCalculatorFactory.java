package org.example.promotionengine.algorithm.discount;

import org.example.promotionengine.models.PromotionItem;

public interface DiscountCalculatorFactory {
    DiscountCalculator getDiscountCalculator(PromotionItem promotionItem);
}
