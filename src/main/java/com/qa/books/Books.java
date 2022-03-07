package com.qa.books;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // Creates Books as a table
public class Books {

	// defining my variables for the database
	@Id // is the PK of our table
	@Column(name = "Title")
	private String title;
	
	@Column(name = "Author")
	private String author;
	@Column(name = "Price")
	private Double price;
	@Column(name = "Stock")
	private Boolean inStock;

	//no args constructor
	public Books() {}
	
	//full args constructor
	public Books(String title, String author, Double price, Boolean inStock) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.inStock = inStock;
	}

	
	//getters and setters
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
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

	//toString
	@Override
	public String toString() {
		return "Books [title=" + title + ", author=" + author + ", price=" + price + ", inStock=" + inStock + "]";
	}
	

}
