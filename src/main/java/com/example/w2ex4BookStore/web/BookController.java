package com.example.w2ex4BookStore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//1st Comment 

@Controller
public class BookController {
	@RequestMapping("/index")
	public String greeting(Model model) {
		return "";
		
	}
}
