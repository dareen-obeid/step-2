package com.dareen.web.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dareen.web.model.Product;

@Repository
public interface ProductRepositry extends JpaRepository<Product, String> {
	
	

}
