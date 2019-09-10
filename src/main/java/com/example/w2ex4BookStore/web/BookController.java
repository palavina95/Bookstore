package com.example.w2ex4BookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.w2ex4BookStore.domain.Book;
import com.example.w2ex4BookStore.domain.BookRepository;
import com.example.w2ex4BookStore.domain.CategoryRepository;

//1st Comment 

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository catRepository;
	
	@RequestMapping("/index")
	public String greeting(Model model) {
		model.addAttribute("booklist",repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", catRepository.findAll());
        return "addBook";
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:index";
    }
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../index";
    } 
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
        return "editBook";
    }
	
	
}
