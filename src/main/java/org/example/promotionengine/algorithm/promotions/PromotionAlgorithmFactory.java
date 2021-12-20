package org.example.promotionengine.algorithm.promotions;

import org.example.promotionengine.models.PromotionItem;

public interface PromotionAlgorithmFactory {
    PromotionAlgorithm getPromotionAlgorithm(PromotionItem promotionItem);
}
