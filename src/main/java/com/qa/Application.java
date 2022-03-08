package com.qa;

import java.io.IOException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qa.entrance.Entrance;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		
		Entrance.entrance();
		

	}

}
