package hh.swd20.Bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Bookstore.domain.BookRepository;

//Add a new controller called BookController which handle get request to the path /index 
@Controller
public class BookController {
	
	@Autowired
	BookRepository bookRepository;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String Books() {
	
	return "welcome";
	}
	
}
