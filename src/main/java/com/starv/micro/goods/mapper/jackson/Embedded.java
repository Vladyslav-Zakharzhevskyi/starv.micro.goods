package com.starv.micro.goods.mapper.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Embedded {
    @JsonProperty("products_availability")
    private List<ProductAvailability> productAvailabilities;

    public List<ProductAvailability> getProductAvailabilities() {
        return productAvailabilities;
    }
}
