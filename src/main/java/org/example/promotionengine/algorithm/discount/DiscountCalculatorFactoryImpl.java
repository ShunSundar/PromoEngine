package org.example.promotionengine.algorithm.discount;

import org.example.promotionengine.models.PromotionItem;
import org.example.promotionengine.models.PromotionType;

public class DiscountCalculatorFactoryImpl implements DiscountCalculatorFactory{

    private final AmountBasedDiscountCalculator amountBasedDiscountCalculator;
    private final RateBasedDiscountCalculator rateBasedDiscountCalculator;

    public DiscountCalculatorFactoryImpl(AmountBasedDiscountCalculator amountBasedDiscountCalculator,RateBasedDiscountCalculator rateBasedDiscountCalculator) {
        this.amountBasedDiscountCalculator = amountBasedDiscountCalculator;
        this.rateBasedDiscountCalculator = rateBasedDiscountCalculator;
    }

    @Override
    public DiscountCalculator getDiscountCalculator(PromotionItem promotionItem) {
        if(PromotionType.RATE == promotionItem.getPromotionType()) {
            return rateBasedDiscountCalculator;
        } else {
            return amountBasedDiscountCalculator;
        }
    }
}
