package com.starv.micro.goods.eureka;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;
import com.netflix.eureka.registry.InstanceRegistry;
import com.starv.micro.goods.eureka.exception.InstanceIsNotAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class EurekaImpl implements Eureka {

    @Autowired
    private InstanceRegistry registry;

    @Override
    public InstanceInfo getShuffledInstanceInfo(String name) throws InstanceIsNotAvailableException {
        Application application = registry.getApplication(name);
        if (application == null) {
            throw new InstanceIsNotAvailableException(name);
        }
        //filter only running
        application.shuffleAndStoreInstances(true);

        final List<InstanceInfo> instances = application.getInstances();
        final int instanceIdx = ThreadLocalRandom.current().nextInt(0, instances.size());
        return instances.get(instanceIdx);
    }

}
