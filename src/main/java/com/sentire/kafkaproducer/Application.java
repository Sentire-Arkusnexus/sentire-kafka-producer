package com.sentire.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;

import springfox.documentation.oas.annotations.EnableOpenApi;

import com.sentire.kafkaproducer.service.Producer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;

@SpringBootApplication
@EnableOpenApi
public class Application {

	private final Producer producer;

	@Autowired
	private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

	@Autowired
	public Application(Producer producer) {
		this.producer = producer;
	}
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.run(args);
	}

}
