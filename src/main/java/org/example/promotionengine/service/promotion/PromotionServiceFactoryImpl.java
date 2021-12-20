package org.example.promotionengine.service.promotion;

public class PromotionServiceFactoryImpl implements PromotionServiceFactory {

    private final StaticPromotionService staticPromotionService;

    public PromotionServiceFactoryImpl(StaticPromotionService staticPromotionService) {
        this.staticPromotionService = staticPromotionService;
    }
    @Override
    public PromotionService getPromotionService() {
        return staticPromotionService;
    }
}
