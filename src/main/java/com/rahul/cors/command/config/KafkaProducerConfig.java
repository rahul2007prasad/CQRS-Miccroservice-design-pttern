package com.rahul.cors.command.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;



@Configuration
public class KafkaProducerConfig {
	/*
	 * @Bean public NewTopic createTopic() { return new NewTopic("rahul-topic-4", 5,
	 * (short) 1);// topic name,num of partitions, replication factor
	 * 
	 * }
	 * 
	 * @Bean public NewTopic createTopic2() { return new NewTopic("customer", 3,
	 * (short) 1);// topic name,num of partitions, replication factor
	 * 
	 * }
	 */
	
	
	// for object serialization without application properties configuration
	@Bean
	public Map<String, Object> producerConfig() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				StringSerializer.class);
		
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				JsonSerializer.class);
		return props;
		
	}
	
	@Bean
	public ProducerFactory<String,Object> producerFactory(){
		return new DefaultKafkaProducerFactory<>(producerConfig());
	}
	
	@Bean
	public KafkaTemplate<String,Object> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
	
}
