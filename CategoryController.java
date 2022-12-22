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

import com.spring.rest.test.exercise.main.model.Category;
import com.spring.rest.test.exercise.main.repository.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@PostMapping("/create")
	public Category createCategory(@RequestBody Category category) {
        
		return categoryRepository.save(category);
    }
	
	@GetMapping
	public List<Category> getAllCategory(){
		return categoryRepository.getAll();
	}
	
	@GetMapping("{id}")
	public Category getCategoryById(@PathVariable  long id){
		Category category = categoryRepository.getById(id);
                
        return category;
	}

	// Find Category By Name
	@GetMapping("/findbyname/{name}")
	public Category getCategoryByName(@PathVariable  String name){
	
		Category category = categoryRepository.getByName(name);
                
        return category;
	}
	
	// Get By Names
	@GetMapping("/names/{substring}")
	public List<Category> getByNames(@PathVariable String substring){
	
		List<Category> categories = categoryRepository.getByNames(substring);
                
        return categories;
	}
	
	@PutMapping("{id}")
    public Category updateCategory(@PathVariable long id,@RequestBody Category category){
		Category updateCategory = categoryRepository.getById(id);
		
		updateCategory.setName(updateCategory.getName());
		updateCategory.setDescription(updateCategory.getDescription());
		
		categoryRepository.save(updateCategory);

        return updateCategory;
    }

	@DeleteMapping("{id}")
    public Category deleteCategory(@PathVariable long id){

		Category category = categoryRepository.getById(id);

        categoryRepository.delete(category);

        return category;

    }	

}
