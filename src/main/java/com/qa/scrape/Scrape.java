package com.qa.scrape;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;

import com.qa.Application;

public class Scrape extends Application {

	//String to store the data
	static ArrayList<String> scrapedData = new ArrayList<>();
	
	public Scrape(){}
	
	public static void Scrape() throws IOException {


		SpringApplication.run(Scrape.class);
		// web scraping site set up for people to test web scraping - all data is fake and randomly assigned
	Document doc = Jsoup.connect("https://books.toscrape.com/").get();
	Elements elements = doc.getAllElements(); //getElementsByAttribute("product_price"); //getElementsByTag("a");
	for(
	Element x:elements)
	{
		// This section is still very much a work in progress and will be tidied up in due course
		
		
		//if(x.text().contains("scott")) {
		
			//System.out.println(x.text());
			scrapedData.add (x.text());
			//String year =x.select("article.prduct_pod span.secondaryInfo").text();
			//String title = x.select("td.posterColum img").attr("alt"); 
			//System.out.println(title);
			//System.out.println(year); 
			//String title1 = doc.getTitleText();
			//System.out.println("Page Title: " + title1);
			//Elements titleUrl = doc.getElementsByAttributeValue("class", "topic starter");
			//String title1 = titleUrl.text();
			//System.out.println(title1);
			
		//}
			
	}
	// this test output will be removed once the correct data is achieved
	System.out.println(scrapedData);
}
	

/*
 * Document doc =
 * Jsoup.connect("https://www.imdb.com/chart/top").timeout(6000).get();
 * 
 * Elements body = doc.select("tbody.lister-list")
 * 
 * //System.out.println(body.select("tr").size());
 * 
 * for (Element e : body.select("tr")) {
 * 
 * String img = e.select("td.posterColum img").attr("src");
 * System.out.println(img); String title =
 * e.select("td.posterColum img").attr("alt"); System.out.println(title); String
 * year =
 * e.select("td.posterColum span.secondaryInfo").text().replaceAll("[\\d]", "");
 * System.out.println(year); String rate =
 * e.select("td.ratingColum.imdbRating").text().trim();
 * System.out.println(rate); }
 */



}
