package com.qa.books;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data

@Entity // Creates Books as a table
public class Books {


	// __________________________________________________________________________

	// __________________Defining my variables for the database____________________

	@Id // is the PK of our table
	@Column(name = "ID")
	private Integer id;
	@Column(name = "Title")
	private String title;
	@Column(name = "Price")
	private Double price;
	@Column(name = "Stock")
	private Boolean inStock;

	// __________________________________________________________________________

	// __________________________No args Constructor____________________________
	
	public Books() {
	}


	// __________________________________________________________________________

	// _________________________full args constructor______________________________
	
	public Books(String title, Integer id, Double price, Boolean inStock) {
		super();
		this.title = title;
		this.id = id;
		this.price = price;
		this.inStock = inStock;
	}

	// __________________________________________________________________________

	// ____________________full args constructor without id_________________________
	
	public Books(String title, Double price, Boolean inStock) {
		super();
		this.title = title;
		this.price = price;
		this.inStock = inStock;
	}

}
