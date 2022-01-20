package com.java.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.springbootcrud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	Product findByName(String name);

}
