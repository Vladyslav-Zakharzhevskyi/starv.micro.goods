package com.starv.micro.goods.conf.ann;


import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@EnableEurekaServer
public @interface EurekaServer {
}
