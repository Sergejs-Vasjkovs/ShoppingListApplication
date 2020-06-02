package com.javaguru.shoppinglist.dto;

import java.util.Objects;

public class ProductToUserDTO {

    private Long productId;
    private Long userId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductToUserDTO that = (ProductToUserDTO) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, userId);
    }

    @Override
    public String toString() {
        return "ProductToUserDTO{" +
                "productId=" + productId +
                ", userId=" + userId +
                '}';
    }
}
