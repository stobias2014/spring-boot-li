package com.tobias.saul.springmvcli.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tobias.saul.springmvcli.model.Product;
import com.tobias.saul.springmvcli.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping
	public String searchForProducts(Model model, @ModelAttribute("product") Product product) {
		
		List<Product> products = productService.findByName(product.getName());
		model.addAttribute("products", products);
		
		return "products";
	}

}
