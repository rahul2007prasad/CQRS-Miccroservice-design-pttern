package com.rahul.cors.command.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.cors.command.dto.ProductEvent;
import com.rahul.cors.command.entity.Product;
import com.rahul.cors.command.service.ProductCommandService;

@RestController
@RequestMapping("/products")
public class ProductCommandController {

	@Autowired
	private ProductCommandService productCommandService;
	
	
	@PostMapping("")
	public Product createProduct(@RequestBody ProductEvent productEvent) {
		return productCommandService.createProduct(productEvent);
	}
	
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable long id ,@RequestBody ProductEvent productEvent) {
		return productCommandService.updateProduct(id, productEvent);
	}
	
}
