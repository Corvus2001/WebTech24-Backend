/** package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
		"spring.datasource.url=${DB_URL}",
		"spring.datasource.username=${DB_USERNAME}",
		"spring.datasource.password=${DB_PASSWORD}"
})
class ToDoBackendApplicationTests {

	@Test
	void contextLoads() {
	}

}

**/