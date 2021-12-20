package org.example.promotionengine.algorithm.promotions;

import org.example.promotionengine.models.PromotionItem;

public class PromotionAlgorithmFactoryImpl implements PromotionAlgorithmFactory{
    private final SingleLinePromotion singleLinePromotion;
    private final BundlePromotion bundlePromotion;

    public PromotionAlgorithmFactoryImpl(SingleLinePromotion singleLinePromotion,BundlePromotion bundlePromotion) {
        this.singleLinePromotion = singleLinePromotion;
        this.bundlePromotion = bundlePromotion;
    }

    @Override
    public PromotionAlgorithm getPromotionAlgorithm(PromotionItem promotionItem) {
        return promotionItem.isMultiLinePromotion() ? bundlePromotion : singleLinePromotion;
    }
}
