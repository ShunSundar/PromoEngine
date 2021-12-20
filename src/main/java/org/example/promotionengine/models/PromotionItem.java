package org.example.promotionengine.models;

import java.math.BigDecimal;
import java.util.List;

public class PromotionItem {

    private int quantity;
    private List<SkuId> productIds;
    private BigDecimal promotionAmount;
    private boolean isMultiLinePromotion;
    private String promotionName;
    private PromotionType promotionType;

    public int getQuantity() {
        return quantity;
    }

    public List<SkuId> getProductIds() {
        return productIds;
    }

    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }

    public boolean isMultiLinePromotion() {
        return isMultiLinePromotion;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public PromotionType getPromotionType() {
        return promotionType;
    }

    public static class Builder {
        private final PromotionItem promotionItem = new PromotionItem();

        public PromotionItem build() {
            return promotionItem;
        }

        public PromotionItem.Builder quantity(int quantity) {
            promotionItem.quantity = quantity;
            return this;
        }

        public PromotionItem.Builder productId(List<SkuId> productIds) {
            promotionItem.productIds = productIds;
            return this;
        }

        public PromotionItem.Builder promotionAmount(BigDecimal promotionAmount) {
            promotionItem.promotionAmount = promotionAmount;
            return this;
        }

        public PromotionItem.Builder isMultiLinePromotion(boolean isMultiLinePromotion) {
            promotionItem.isMultiLinePromotion = isMultiLinePromotion;
            return this;
        }

        public PromotionItem.Builder promotionName(String promotionName) {
            promotionItem.promotionName = promotionName;
            return this;
        }

        public PromotionItem.Builder promotionType(PromotionType promotionType) {
            promotionItem.promotionType = promotionType;
            return this;
        }
    }
}
