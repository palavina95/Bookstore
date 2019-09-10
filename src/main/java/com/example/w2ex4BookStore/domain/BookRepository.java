package com.example.w2ex4BookStore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	List<Book> findByIsbn(String isbn);

}
