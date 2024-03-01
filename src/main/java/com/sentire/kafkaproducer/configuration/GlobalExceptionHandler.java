package com.sentire.kafkaproducer.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sentire.kafkaproducer.exception.ApiError;
import com.sentire.kafkaproducer.exception.DeviceNotFoundException;
import com.sentire.kafkaproducer.exception.DeviceResourceNotFoundException;
import com.sentire.kafkaproducer.exception.UserDataNotFoundException;
import com.sentire.kafkaproducer.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler({DeviceResourceNotFoundException.class})
  public ResponseEntity<Object> handleDeviceResourceNotFoundException(DeviceResourceNotFoundException ex) {
    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
    return buildResponseEntity(apiError);
  }
  
  @ExceptionHandler({UserNotFoundException.class})
  public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
    return buildResponseEntity(apiError);
  }
  
  @ExceptionHandler({DeviceNotFoundException.class})
  public ResponseEntity<Object> handleDeviceNotFoundException(DeviceNotFoundException ex) {
    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
    return buildResponseEntity(apiError);
  }
  
  @ExceptionHandler({Exception.class})
  public ResponseEntity<Object> handleAllExceptions(Exception ex) {
    ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    return buildResponseEntity(apiError);
  }
  
  @ExceptionHandler({UserDataNotFoundException.class})
  public ResponseEntity<Object> handleResourceNotFoundException(UserDataNotFoundException ex) {
    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
    return buildResponseEntity(apiError);
  }
  
  private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
    return new ResponseEntity(apiError, (HttpStatus)apiError.getStatus());
  }
  
}
