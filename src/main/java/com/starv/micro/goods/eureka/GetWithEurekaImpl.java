package com.starv.micro.goods.eureka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;
import com.netflix.eureka.registry.InstanceRegistry;
import com.starv.micro.goods.eco.Architecture;
import com.starv.micro.goods.mapper.jackson.ProductAvailability;
import com.starv.micro.goods.mapper.jackson.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GetWithEurekaImpl implements GetWithEureka {

    @Autowired
    private InstanceRegistry registry;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<ProductAvailability> productsAvailability() {
        Application application = registry.getApplication(Architecture.AVAILABILITY_SERVICE);
        application.shuffleAndStoreInstances(true);
        InstanceInfo instanceInfo = application.getInstances().get(0);

        String url = instanceInfo.getHomePageUrl() + "availability";
        String response = restTemplate.getForObject(url, String.class);

        Root root = null;
        try {
            root = objectMapper.readValue(response, Root.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("The error has occurred during parsing response from eco-system server");
        }

        return root.getEmbedded().getProductAvailabilities();
    }

    @Override
    public List<ProductAvailability> productsAvailability(List<String> sku) {
        return null;
    }

}
