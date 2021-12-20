package org.example.promotionengine.models;

import java.util.Arrays;

public enum PromotionType {
    AMOUNT,
    RATE,
    UNKNOWN;

    public static PromotionType getPromotionType(String promotionType) {
        return Arrays.stream(PromotionType.values())
                .filter(type -> type.name().equals(promotionType))
                .findAny()
                .orElse(UNKNOWN);
    }
}
