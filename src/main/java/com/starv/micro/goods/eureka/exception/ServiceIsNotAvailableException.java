package com.starv.micro.goods.eureka.exception;

public class ServiceIsNotAvailableException extends Exception {

    private final String serviceName;

    public ServiceIsNotAvailableException(String serviceName) {
        this.serviceName = serviceName;
    }
}
