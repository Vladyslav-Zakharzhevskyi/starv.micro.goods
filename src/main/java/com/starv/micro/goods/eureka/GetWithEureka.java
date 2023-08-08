package com.starv.micro.goods.eureka;

import com.starv.micro.goods.mapper.jackson.ProductAvailability;

import java.util.List;

public interface GetWithEureka {
     List<ProductAvailability> productsAvailability();
     List<ProductAvailability> productsAvailability(List<String> sku);
}
