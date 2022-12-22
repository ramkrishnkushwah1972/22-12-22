package com.spring.rest.test.exercise.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",length=11)
	private long id;
	
	@Column(name="name",length=50 , nullable=false)
	private String name;
	
	@Column(name="price" ,nullable=false)
	private double price;
	
	
	@Column(name="units_in_stock")
	private int unitsInStock;
	

	@Column(name="discontinued")
	private boolean discontinued;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Product() {
		super();
	}

	public Product(long id, String name, double price, int unitsInStock, boolean discontinued, Category category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.unitsInStock = unitsInStock;
		this.discontinued = discontinued;
		this.category = category;
	}
	
	public Product(String name, double price, int unitsInStock, boolean discontinued, Category category) {
		this.name = name;
		this.price = price;
		this.unitsInStock = unitsInStock;
		this.discontinued = discontinued;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", unitsInStock=" + unitsInStock
				+ ", discontinued=" + discontinued + ", category=" + category + "]";
	}
	
	
	
	
	
}
