package com.tobias.saul.springmvcli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobias.saul.springmvcli.model.Product;
import com.tobias.saul.springmvcli.repository.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> findByName(String name) {
		List<Product> products = productRepository.findByNameContaining(name);
		
		return products;
	}
	
}
