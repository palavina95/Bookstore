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
import com.example.w2ex4BookStore.domain.User;
import com.example.w2ex4BookStore.domain.UserRepository;

@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookInit(BookRepository repository, CategoryRepository catRepository, UserRepository uRepository) {
		return (args) -> {
			log.info("save a couple of categories");
			catRepository.save(new Category("Tragedy"));
			catRepository.save(new Category("New"));
			
			log.info("save a couple of books");
			repository.save(new Book("Martin1","Rowlings","2005","PQL-156",14.9,catRepository.findByName("Tragedy").get(0)));
			repository.save(new Book("Martin2","Rowlings","2006","PQL-157",12.9,catRepository.findByName("New").get(0)));
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$10$pcyvJXKC3KyOBx988OOBB.Zx6qTNCWJoUNWW7rAJQPpOWPz0mo/n2", "USER");
			User user2 = new User("admin", "$2a$10$qzjN5i5Azvoq8abOZRbVeu63FKFG3uKKjYLNlu7VM5NFWrW1oIAjK", "ADMIN");
			uRepository.save(user1);
			uRepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
