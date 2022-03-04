package com.qa;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.qa.scrape.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		
		Scrape.Scrape();

	}

}
