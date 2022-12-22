package com.spring.rest.test.exercise.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.rest.test.exercise.main.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>  {


	public Category save(Category category);

	//select * from categories where id=1;
	@Query("select c from Category c where id = ?1")
	public Category getById(long id);

	@Query(value="select * from Categories", nativeQuery=true)
	public List<Category> getAll();
	
	// select * from Categories where name = ‘Beverages’;
	@Query("select c from Category c where name = ?1")
	public Category getByName(String name);

	//select * from Categories where name like ‘Con%’;
	@Query(value="select * from Categories where name like :substring%", nativeQuery=true)
	public List<Category> getByNames(@Param("substring") String substring);

}
