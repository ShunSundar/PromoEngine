package org.example.promotionengine.service.product;

public class ProductServiceFactoryImpl implements ProductServiceFactory{

    private final StaticProductService staticProductService;

    public ProductServiceFactoryImpl(StaticProductService staticProductService) {
        this.staticProductService = staticProductService;
    }

    @Override
    public ProductService getProductService() {
        return staticProductService;
    }
}

