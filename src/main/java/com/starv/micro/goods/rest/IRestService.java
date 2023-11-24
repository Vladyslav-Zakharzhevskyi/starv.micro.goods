package com.starv.micro.goods.rest;

import com.netflix.appinfo.InstanceInfo;
import com.starv.micro.goods.mapper.jackson.ProductAvailability;

import java.util.List;

public interface IRestService {
    List<ProductAvailability> productsAvailability(InstanceInfo instanceInfo);
    List<ProductAvailability> productsAvailability(List<String> sku);
}
