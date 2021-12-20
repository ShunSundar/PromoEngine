package org.example.promotionengine.models;

import java.math.BigDecimal;

public class Product {
    private SkuId productId;
    private String productName;
    private BigDecimal productPrice;

    public SkuId getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public static class Builder{
        private final Product product = new Product();
        public Product build() {
            return product;
        }

        public Builder productId(SkuId productId) {
            product.productId = productId;
            return this;
        }

        public Builder productName(String productName) {
            product.productName = productName;
            return this;
        }

        public Builder productPrice(BigDecimal productPrice) {
            product.productPrice = productPrice;
            return this;
        }
    }
}
