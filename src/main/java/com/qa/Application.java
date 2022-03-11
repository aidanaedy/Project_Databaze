package com.qa;

import java.io.IOException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qa.entrance.Entrance;

import lombok.Data;

@Data

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {

		// __________________________________________________________________________

		// ______Main application starts and points to the entrance to keep it clean______

		
		Entrance.entrance();

	}

}
