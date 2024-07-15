package com.rahul.cors.command.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.cors.command.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
