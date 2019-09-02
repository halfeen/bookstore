package hh.swd20.Bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Add a new controller called BookController which handle get request to the path /index 
@Controller
public class BookController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String Books() {
	
	return "yep. handles it.";
	}
	
}
