package com.spring.rest.test.exercise.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.test.exercise.main.model.Product;
import com.spring.rest.test.exercise.main.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {
        
		return productRepository.save(product);
    }

	//Get by id
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable  long id){
		Product product = productRepository.getById(id);
                
        return product;
	}
	
	@GetMapping
	public List<Product> getAllProduct(){
		return productRepository.getAll();
	}
	
	// Find Product By Name
	@GetMapping("/findbyname/{name}")
	public Product getProductByName(@PathVariable  String name){
		Product product = productRepository.getByName(name);
        return product;
	}
	
	// Get By Names
	@GetMapping("/names/{substring}")
	public List<Product> getByNames(@PathVariable String substring){
		List<Product> products = productRepository.getByNames(substring);              
        return products;
	}
	
	// Get By Between Price
	@GetMapping("/getbybetweenprice/{iPrice}/{oPrice}")
	public List<Product> getByBetweenPrice(@PathVariable double iPrice,@PathVariable double oPrice){
		List<Product> products = productRepository.getByBetweenPrice(iPrice, oPrice);              
        return products;
	}
	
	// Get Discontinued Products
	@GetMapping("/discontinued")
	public List<Product> getDiscontinuedProducts(){
		List<Product> products = productRepository.getDiscontinuedProducts();              
        return products;
	}
	
	@PutMapping("{id}")
    public Product updateProduct(@PathVariable long id,@RequestBody Product product){
		Product updateProduct = productRepository.getById(id);
		
		updateProduct.setName(updateProduct.getName());
		updateProduct.setDiscontinued(updateProduct.isDiscontinued());
		updateProduct.setPrice(updateProduct.getPrice());
		updateProduct.setUnitsInStock(updateProduct.getUnitsInStock());
		
		productRepository.save(updateProduct);

        return updateProduct;
    }

	@DeleteMapping("{id}")
    public Product deleteProduct(@PathVariable long id){
		Product product = productRepository.getById(id);
        productRepository.delete(product);
        return product;

    }	
	

}
