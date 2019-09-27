package hh.swd20.Bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository cateRepository;

	//Welcome index page
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String Books() {
		return "welcome";
	}
	
	//Listing all books
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getBooks(Model model) {
		List<Book> books = (List<Book>) bookRepository.findAll();
		model.addAttribute("books", books);
		return "booklist";
	}
	
	//RESTful service to get all books
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> getBookRest() {
		return (List<Book>) bookRepository.findAll();
	}
	
	
	//RESTful service to get book by id
	@RequestMapping(value="/books/{isbn}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> getBookRest(@PathVariable("isbn") String bookId) {
		return bookRepository.findById(bookId);
	}
	
	//Restful service to save new book
	@RequestMapping(value="/books", method = RequestMethod.POST)
	public @ResponseBody Book saveBookRest(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	//Home page of REST services
	@RequestMapping(value="/resthome", method = RequestMethod.GET)
	public String getRestHome() {
		return "resthomepage";
	}
	

	//empty form to add new book 1
	@RequestMapping(value = "/savebook", method = RequestMethod.GET)
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", cateRepository.findAll());
		return "addbook";
	}
	//saving the book 2
	@RequestMapping(value= "/savebook", method = RequestMethod.POST)
	public String saveNewBook(@ModelAttribute Book book) {
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	//deleting a book 3
	@RequestMapping(value = "/deletebook/{isbn}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("isbn") String bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	//edit book 4
	@RequestMapping(value= "/editbook/{isbn}")
	public String saveBook(@PathVariable("isbn") String bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("categories", cateRepository.findAll());
		return "editbook";
	}
	
}














