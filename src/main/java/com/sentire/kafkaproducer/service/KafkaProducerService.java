package com.sentire.kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

// @Service
public class KafkaProducerService {

    // @Autowired
    // private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topicName, String msg) {
        //kafkaTemplate.send(topicName, msg);
    }
    
}
