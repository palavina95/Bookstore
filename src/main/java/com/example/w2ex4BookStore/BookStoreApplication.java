package com.example.w2ex4BookStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.w2ex4BookStore.domain.Book;
import com.example.w2ex4BookStore.domain.BookRepository;
import com.example.w2ex4BookStore.domain.Category;
import com.example.w2ex4BookStore.domain.CategoryRepository;


@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookInit(BookRepository repository, CategoryRepository catRepository) {
		return (args) -> {
			log.info("save a couple of categories");
			catRepository.save(new Category("Tragedy"));
			catRepository.save(new Category("New"));
			log.info("save a couple of books");
			repository.save(new Book("Martin1","Rowlings","2005","PQL-156",14.9,catRepository.findByName("Tragedy").get(0)));
			repository.save(new Book("Martin2","Rowlings","2006","PQL-157",12.9,catRepository.findByName("New").get(0)));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
