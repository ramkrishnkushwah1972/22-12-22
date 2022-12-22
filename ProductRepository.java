package com.spring.rest.test.exercise.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.rest.test.exercise.main.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	//Find by id
	public Product getById(long id);

	@Query(value = "select * from Products", nativeQuery = true)
	public List<Product> getAll();
	
	//Get by name
	public Product getByName(String name);

	@Query("select p from Product p where discontinued = false")
	public List<Product> getDiscontinuedProducts();
	
	// select * from Categories where name like ‘Con%’;
	@Query(value = "select * from Products where name like :substring%", nativeQuery = true)
	public List<Product> getByNames(@Param("substring") String substring);

	// select * from products where price between 300 and 1200;
	@Query(value = "select * from Products where price> :iPrice and price< :oPrice", nativeQuery = true)
	public List<Product> getByBetweenPrice(@Param("iPrice") double iPrice, @Param("oPrice") double oPrice);


}
