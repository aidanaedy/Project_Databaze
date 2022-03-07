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

public class Scrape extends Application {

	// Variables and lists to store the data
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

	// web scraping site set up for people to test web scraping - all data is fake
	// and randomly assigned
	final static String url = "https://books.toscrape.com/";

	public Scrape() {
	}

	public static ArrayList<String> Scrape() throws IOException {

		SpringApplication.run(Scrape.class);
		// connects with the url to get the site
		try {
			Document doc = Jsoup.connect(url).get();

			// get elements by price
			Elements elements = doc.getElementsByClass("price_color");

			temp1 = elements.removeClass("price_color");
			// removing the junk from the data
			scrapedData = temp1.toString().replaceAll("(<p>|</p>)", "");
			// split on new line
			String[] intoLines1 = scrapedData.split("\\r?\\n");

			// get elements by instock availability;
			Elements elements2 = doc.getElementsByClass("instock availability");
			temp2 = elements2.removeClass("instock availability");
			// removing the junk from the data
			scrapedData2 = temp2.toString()
					.replaceAll("(<p class=\"instock availability\"> <i class=\"icon-ok\"></i> |</p>)", "");
			// split on new line
			String[] intoLines2 = scrapedData2.split("\\r?\\n");

			// get item title from thumb nail description
			Elements elements3 = doc.getElementsByClass("thumbnail");
			temp3 = elements3.removeClass("thumbnail");
			// removing the junk from the data
			scrapedData3 = temp3.toString().replaceAll("(\">)", "");

			// splitting the junk information from the title
			// split on new line
			String[] intoLines3 = scrapedData3.split("\\r?\\n");

			// moving the data to the new ArrayLists for use
			for (int x = 0; x < intoLines3.length; x++) {
				newDataTitle.add(intoLines3[x].substring(71, intoLines3[x].length()));
				newDataPrice.add(intoLines1[x]);
				newDataStock.add(intoLines2[x]);
				newDataID.add(x + 1);
			}

			// This print to the screen of the data will be removed before finalising
			System.out.println(newDataPrice);
			System.out.println(newDataStock);
			System.out.println(newDataID);
			System.out.println(newDataTitle);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return scrapedDataFull;
	}

	public static ArrayList<String> scrapedData() {
		return scrapedDataFull;
	}

}
