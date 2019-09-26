package hh.swd20.Bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.CategoryRepository;

//Add a new controller called BookController which handle get request to the path /index 
@Controller
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository cateRepository;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String Books() {
	
	return "welcome";
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getBooks(Model model) {
		List<Book> books = (List<Book>) bookRepository.findAll();
		model.addAttribute("books", books);
		return "booklist";
	}
	
	
	//Add Create and Delete functionalities to your Bookstore application
	//For deletion use @PathVariable annotation
	
	
	//empty form to add new book
	@RequestMapping(value = "/savebook", method = RequestMethod.GET)
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", cateRepository.findAll());
		return "addbook";
	}
	//saving the book
	@RequestMapping(value= "/savebook", method = RequestMethod.POST)
	public String saveNewBook(@ModelAttribute Book book) {
		bookRepository.save(book);
		return "redirect:/books";
		//    	model.addAttribute("departments", drepository.findAll());
	}
	
	//deleting a book
	@RequestMapping(value = "/deletebook/{isbn}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("isbn") String bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:../books";
	}
	
	//edit book
	@RequestMapping(value= "/editbook/{isbn}")
	public String saveBook(@PathVariable("isbn") String bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("categories", cateRepository.findAll());
		return "editbook";
	}
	
}

/*Add edit functionality to your bookstore. Create edit link after delete link to your listpage. Edit link
will open current book in the edit page.
Tip. Check ‘Add book’-functionality from the controller. In add functionality you added new book
object to model but now you will add current book object to model. You also have to send current
book id from the list page to controller (like you did in delete link).*/













