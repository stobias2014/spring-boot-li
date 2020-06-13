package com.tobias.saul.springmvcli.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tobias.saul.springmvcli.model.Product;
import com.tobias.saul.springmvcli.service.ProductService;

@Controller
//@RequestMapping("/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("searchByName")
	public String searchForProducts(Model model, @RequestParam("name") String name, RedirectAttributes redirectAttributes) {
		
		System.out.println("Name: " + name);
		
		List<Product> products = productService.findByName(name);
		
		System.out.println(products);
		
		model.addAttribute("products", products);
		
		return "products";
	}

}
