package org.example.promotionengine.algorithm.promotions;

import org.example.promotionengine.models.Cart;
import org.example.promotionengine.models.PromotionItem;

public class SingleLinePromotion implements PromotionAlgorithm{
    @Override
    public boolean isValid(Cart cart, PromotionItem promotionItem) {
        return false;
    }

    @Override
    public void updatePromotionDiscount(Cart cart, PromotionItem promotionItem) {

    }
}
