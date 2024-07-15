package com.rahul.cors.command.dto;

import com.rahul.cors.command.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEvent {

	
	private String eventtype;
	private Product product;
}
