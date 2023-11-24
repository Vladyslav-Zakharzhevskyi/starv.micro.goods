package com.starv.micro.goods.eureka;

import com.netflix.appinfo.InstanceInfo;
import com.starv.micro.goods.eureka.exception.InstanceIsNotAvailableException;
import com.starv.micro.goods.mapper.jackson.ProductAvailability;

import java.util.List;

public interface Eureka {
     InstanceInfo getShuffledInstanceInfo(String name) throws InstanceIsNotAvailableException;
}
