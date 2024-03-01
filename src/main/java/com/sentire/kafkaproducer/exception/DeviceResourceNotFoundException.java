package com.sentire.kafkaproducer.exception;

public class DeviceResourceNotFoundException extends RuntimeException {
    public DeviceResourceNotFoundException(String message) {
        super(message);
      }
}
