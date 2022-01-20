package com.java.springbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.springbootcrud.model.Product;
import com.java.springbootcrud.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductService prodService;

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product prod) {
		return prodService.saveProduct(prod);
	}

	@PostMapping("/addProducts")
	public List<Product> addAllProducts(@RequestBody List<Product> prods) {
		return prodService.saveAllProducts(prods);
	}

	@GetMapping("/getProducts")
	public List<Product> getAllProducts() {
		return prodService.getProducts();
	}

	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable int id) {
		return prodService.getProductById(id);
	}

	@GetMapping("/getProductByName/{name}")
	public Product getProductByName(@PathVariable String name) {
		return prodService.getProductByName(name);
	}

	@PutMapping("/updateProduct")
	public Product updateProductById(@RequestBody Product product) {
		return prodService.updateProduct(product);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public String deleteById(@PathVariable int id) {
		return prodService.deleteProductById(id);
	}
}
