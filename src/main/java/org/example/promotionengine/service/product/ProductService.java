package org.example.promotionengine.service.product;

import org.example.promotionengine.models.Product;
import org.example.promotionengine.models.SkuId;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProduct(SkuId productId, String productName, BigDecimal productPrice);
}
