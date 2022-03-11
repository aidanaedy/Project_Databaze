package com.qa.scrape;

import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;

import com.qa.Application;
import com.qa.books.Books;

import lombok.Data;

@Data

public class Scrape extends Application {

	
	// __________________________________________________________________________

	// ___________________Variables and lists to store the data______________________

	public static int counter;
	public static ArrayList<String> newDataTitle = new ArrayList<>();
	public static ArrayList<String> newDataPrice = new ArrayList<>();
	public static ArrayList<String> newDataStock = new ArrayList<>();
	public static ArrayList<Integer> newDataID = new ArrayList<>();

	private static String scrapedData;
	private static AbstractList<Element> temp1;
	private static String scrapedData2;
	private static AbstractList<Element> temp2;
	private static String scrapedData3;
	private static AbstractList<Element> temp3;
	private static ArrayList<String> scrapedDataFull;

	static Books books1 = new Books();

	// __________________________________________________________________________

	// _________web scraping site set up for people to test web scraping____________
	// _______________ all data is fake and randomly assigned_______________________

	final static String url = "https://books.toscrape.com/";

	public Scrape() {
	}

	public static Books Scrape() throws IOException {

		SpringApplication.run(Scrape.class);
	// __________________________________________________________________________

	// __________________connects with the url to get the site______________________

		try {
			Document doc = Jsoup.connect(url).get();

	// __________________________________________________________________________

	// _______________________get elements by price_______________________________

			Elements elements = doc.getElementsByClass("price_color");

			temp1 = elements.removeClass("price_color");
	// ____________________removing the junk from the data________________________

			scrapedData = temp1.toString().replaceAll("(<p>|</p>|£)", "");
	// __________________________split on new line_________________________________

			String[] intoLines1 = scrapedData.split("\\r?\\n");
			
	// ___________________get elements by instock availability;______________________

			Elements elements2 = doc.getElementsByClass("instock availability");
			temp2 = elements2.removeClass("instock availability");
	// ____________________removing the junk from the data________________________
			scrapedData2 = temp2.toString()
					.replaceAll("(<p class=\"instock availability\"> <i class=\"icon-ok\"></i> |</p>)", "");
	// __________________________split on new line_________________________________
			String[] intoLines2 = scrapedData2.split("\\r?\\n");

			// get item title from thumb nail description
			Elements elements3 = doc.getElementsByClass("thumbnail");
			temp3 = elements3.removeClass("thumbnail");
	// ____________________removing the junk from the data________________________
			scrapedData3 = temp3.toString().replaceAll("(\">)", "");


	// ________________splitting the junk information from the title__________________
	// __________________________split on new line_________________________________
			String[] intoLines3 = scrapedData3.split("\\r?\\n");

			// moving the data to the new ArrayLists for use
	// __________________________________________________________________________

	// ______________moving the data to the new ArrayLists for use_________________
			for (int x = 0; x < intoLines3.length; x++) {
				newDataTitle.add(intoLines3[x].substring(71, intoLines3[x].length()));
				newDataPrice.add(intoLines1[x]);
				newDataStock.add(intoLines2[x]);
				newDataID.add(x + 1);
			}

	// __________________________________________________________________________
	// ____________Adding the data together and putting it in Books1_______________
	// _____________________in the correct order and format________________________	

			for (int poo = 0; poo < newDataTitle.size(); poo++) {

				String newbie1 = (newDataTitle.get(poo).toString());
				books1.setTitle(newbie1);
				Double newbie2 = Double.valueOf(newDataPrice.get(poo));
				books1.setPrice(newbie2);
				Integer newbie3 = (newDataID.get(poo));
				books1.setId(newbie3);
				Boolean newbie4 = (newDataStock.get(poo).equals("In stock"));
				books1.setInStock(newbie4);

				System.out.println("Website data to be added = " + books1);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println();
		System.out.println("     These values were due to imported into the data base, but because of time constraints, were not added yet, ");
		System.out.println("              however it proves the link, data and formatting is all correct and ready to be added.");
		System.out.println();

		return books1;
	}
  
}
