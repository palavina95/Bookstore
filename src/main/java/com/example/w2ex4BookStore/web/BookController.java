package com.example.w2ex4BookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.w2ex4BookStore.domain.Book;
import com.example.w2ex4BookStore.domain.BookRepository;

//1st Comment 

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@RequestMapping("/index")
	public String greeting(Model model) {
		model.addAttribute("booklist",repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("book", new Book());
        return "addBook";
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:index";
    }
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../index";
    } 
}
