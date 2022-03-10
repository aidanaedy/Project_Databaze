package com.qa.books;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // Creates Books as a table
public class Books {

	// defining my variables for the database

	@Id // is the PK of our table
	@Column(name = "ID")
	private Integer id;
	@Column(name = "Title")
	private String title;
	@Column(name = "Price")
	private Double price;
	@Column(name = "Stock")
	private Boolean inStock;

	// no args constructor
	public Books() {
	}

	// full args constructor
	public Books(String title, Integer id, Double price, Boolean inStock) {
		super();
		this.title = title;
		this.id = id;
		this.price = price;
		this.inStock = inStock;
	}
	
	// full args constructor without id
	public Books(String title, Double price, Boolean inStock) {
		super();
		this.title = title;
		this.price = price;
		this.inStock = inStock;
	}

	// getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getInStock() {
		return inStock;
	}

	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}

	// toString
	@Override
	public String toString() {
		return "Books [title=" + title + ", id=" + id + ", price=" + price + ", inStock=" + inStock + "]";
	}

}
