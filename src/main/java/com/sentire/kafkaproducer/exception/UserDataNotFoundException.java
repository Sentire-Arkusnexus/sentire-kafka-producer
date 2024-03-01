package com.sentire.kafkaproducer.exception;

public class UserDataNotFoundException extends RuntimeException {
    public UserDataNotFoundException(String message) {
        super(message);
      }
}
