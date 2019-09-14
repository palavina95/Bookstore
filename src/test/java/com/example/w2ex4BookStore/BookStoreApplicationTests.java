package com.example.w2ex4BookStore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.w2ex4BookStore.web.BookController;

/**
 * Testing that the context is creating your controller
 * 
 * @author Vivian
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookStoreApplicationTests {

	@Autowired
	private BookController controller;
	
	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
