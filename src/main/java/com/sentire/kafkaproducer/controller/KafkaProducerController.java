package com.sentire.kafkaproducer.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sentire.kafkaproducer.dto.UserDataDTO;
import com.sentire.kafkaproducer.service.KafkaProducerService;
import com.sentire.kafkaproducer.service.Producer;

import jakarta.validation.Valid;

@RestController
@RequestMapping({"/kafkaproducer"})
public class KafkaProducerController {

  @Autowired
  private Producer producerService;
  
  @Value(value = "${spring.kafka.sentire.topic}")
  private String TOPIC;
  
  @RequestMapping(value = "send", method = RequestMethod.POST, produces = { "application/json" })
    public ResponseEntity<?> send(@Valid @RequestBody UserDataDTO msg) {
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String msgStr = ow.writeValueAsString(msg);
            String out = producerService.sendMessage(TOPIC, msgStr);
            return ResponseEntity.ok("Message sent to Kafka topic: " + msgStr);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(e);
        }
    }
    
}
