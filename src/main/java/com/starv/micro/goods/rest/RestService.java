package com.starv.micro.goods.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.starv.micro.goods.mapper.jackson.ProductAvailability;
import com.starv.micro.goods.mapper.jackson.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestService implements IRestService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<ProductAvailability> productsAvailability(InstanceInfo instanceInfo) {
        String url = instanceInfo.getHomePageUrl() + "availability";
        //do a call to Availability service and get data back
        /*
        * Parse response
        **/
        Root root = restTemplate.getForObject(url, Root.class);
        return root.getEmbedded().getProductAvailabilities();
    }

    @Override
    public List<ProductAvailability> productsAvailability(List<String> sku) {
        return null;
    }
}
