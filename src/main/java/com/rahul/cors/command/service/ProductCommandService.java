package com.rahul.cors.command.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rahul.cors.command.dto.ProductEvent;
import com.rahul.cors.command.entity.Product;
import com.rahul.cors.command.repo.ProductRepository;

@Service

public class ProductCommandService {

	
	@Autowired
	private ProductRepository productRepository;

	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	
	public Product createProduct(ProductEvent productEvent) {
		Product productDO = productRepository.save(productEvent.getProduct());
		ProductEvent event = new ProductEvent("CreateProduct" ,productDO);
		kafkaTemplate.send("cqrs-product-event-topic" ,event);
		return productDO;
	}
	
	
	
	public Product updateProduct(long id , ProductEvent productEvent) {
		Product existingProduct = productRepository.findById(id).get();
		
		Product newProduct = productEvent.getProduct();
		
		existingProduct.setDescription(newProduct.getDescription());
		existingProduct.setName(newProduct.getName());
		existingProduct.setPrice(newProduct.getPrice());
		Product productDO = productRepository.save(existingProduct);
		ProductEvent event = new ProductEvent("UpdateProduct" ,productDO);
		kafkaTemplate.send("cqrs-product-event-topic" ,event);
		return productDO;
		 
	}
	
	
	
}
