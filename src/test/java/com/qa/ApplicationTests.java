package com.qa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.entrance.Entrance;

import lombok.Data;

@Data

@SpringBootTest
class ApplicationTests {

	@Test
	void Loads() {
	}

	@Test
	void loadedEntrance() {
		assertThat(Entrance.class).isNotNull();
		}
	
	@Test
	void loadedApp() {
		assertThat(Application.class).isNotNull();
		}
	
}
