package org.example.promotionengine.algorithm.promotions;

import org.example.promotionengine.models.Cart;
import org.example.promotionengine.models.PromotionItem;

public interface PromotionAlgorithm {
    boolean isValid(Cart cart, PromotionItem promotionItem);
    void updatePromotionDiscount(Cart cart,PromotionItem promotionItem);
}
