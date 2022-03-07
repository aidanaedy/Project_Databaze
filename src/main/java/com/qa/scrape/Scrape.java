package com.qa.scrape;

import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;

import com.qa.Application;

public class Scrape extends Application {

	// String to store the data
	public static String scrapedData;
	public static AbstractList<Element> temp1;
	public static String scrapedData2;
	public static AbstractList<Element> temp2;
	public static String scrapedData3;
	public static AbstractList<Element> temp3;
	public static ArrayList<String> scrapedDataFull;

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

			Elements elements = doc.getElementsByClass("price_color");   // get elements by price - //

			temp1 = elements.removeClass("price_color");
			scrapedData = temp1.toString().replaceAll("(<p>|</p>)", ""); //removing the junk from the data

			Elements elements2 = doc.getElementsByClass("instock availability"); // get elements by availability;
			temp2 = elements2.removeClass("instock availability");
			scrapedData2 = temp2.toString()
					.replaceAll("(<p class=\"instock availability\"> <i class=\"icon-ok\"></i> |</p>)", "");//removing the junk from the data

			Elements elements3 = doc.getElementsByClass("thumbnail");   // get item details from thumbnail description
			temp3 = elements3.removeClass("thumbnail");                 //removing the junk from the data
			scrapedData3 = temp3.toString().replaceAll("(<img src=\"media/cache/)", "").replaceAll("(jpg\" alt)", "")
					.replaceAll("(\">)", "").replaceAll("(/)", "").replaceAll("(\")", "").replaceAll("[.]", "");

			//splitting the information into ID and title
			List<String> list= Stream.of(scrapedData3.split("=")).collect(Collectors.toList());

			// This print to the screen will be removed once I adequately get the
			// information formated and inserted

			System.out.println(scrapedData);
			System.out.println(scrapedData2);
			System.out.println(scrapedData3);
			System.out.println(list);

			for (Element x : elements)

			{

				// for loop will appear here

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// this test output will be removed once the correct data is achieved
		// System.out.println(scrapedData);

		return scrapedDataFull;
	}

	public static ArrayList<String> scrapedData() {
		return scrapedDataFull;
	}

}
