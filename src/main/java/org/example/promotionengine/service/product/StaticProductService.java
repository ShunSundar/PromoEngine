package org.example.promotionengine.service.product;

import org.example.promotionengine.models.Product;
import org.example.promotionengine.models.SkuId;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StaticProductService implements ProductService{
    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(getProduct(SkuId.A,"Product-1",BigDecimal.valueOf(50)));
        products.add(getProduct(SkuId.B,"Product-2",BigDecimal.valueOf(30)));
        products.add(getProduct(SkuId.C,"Product-3",BigDecimal.valueOf(20)));
        products.add(getProduct(SkuId.D,"Product-4",BigDecimal.valueOf(10)));
        return products;
    }

    @Override
    public Product getProduct(SkuId productId, String productName, BigDecimal productPrice) {
        return new Product.Builder().productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .build();
    }
}
