package com.starv.micro.goods.eureka.exception;

public class InstanceIsNotAvailableException extends RuntimeException {

    private final String serviceName;

    public InstanceIsNotAvailableException(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String getMessage() {
        final String message = super.getMessage();
        return String.format("Service: %s, is not available.", serviceName);
    }
}
