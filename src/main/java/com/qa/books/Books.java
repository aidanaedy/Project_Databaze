package com.qa.books;

public class Books {


	private String title;
	private String author;
	private Double price;
	private Boolean inStock;

	public Books() {}
	
	
	public Books(String title, String author, Double price, Boolean inStock) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.inStock = inStock;
	}

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

	
	@Override
	public String toString() {
		return "Books [title=" + title + ", author=" + author + ", price=" + price + ", inStock=" + inStock + "]";
	}
	

}
