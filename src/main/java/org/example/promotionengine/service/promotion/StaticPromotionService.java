package org.example.promotionengine.service.promotion;

import org.example.promotionengine.models.PromotionItem;
import org.example.promotionengine.models.PromotionType;
import org.example.promotionengine.models.SkuId;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StaticPromotionService implements PromotionService{
    @Override
    public List<PromotionItem> getPromotionItems() {
        List<PromotionItem> promotionItems = new ArrayList<>();
        promotionItems.add(getPromotionItem("Promotion-1",PromotionType.AMOUNT,false,BigDecimal.valueOf(130), Collections.singletonList(SkuId.A),3));
        promotionItems.add(getPromotionItem("Promotion-2",PromotionType.AMOUNT,false,BigDecimal.valueOf(45), Collections.singletonList(SkuId.B),2));
        promotionItems.add(getPromotionItem("Promotion-3",PromotionType.AMOUNT,true,BigDecimal.valueOf(30), Arrays.asList(SkuId.C,SkuId.D),1));
        return promotionItems;
    }

    public PromotionItem getPromotionItem(String promotionName, PromotionType promotionType, boolean isMultiLinePromotion,
                                          BigDecimal promotionAmount, List<SkuId> productId,int quantity)
    {
        return new PromotionItem.Builder().promotionName(promotionName)
                .promotionType(promotionType)
                .isMultiLinePromotion(isMultiLinePromotion)
                .promotionAmount(promotionAmount)
                .productId(productId)
                .quantity(quantity)
                .build();
    }
}
