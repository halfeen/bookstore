package hh.swd20.Bookstore;


import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	//testidatan luonti
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository catrepo, UserRepository urepository) {
		return (args) -> {
			log.info("SAVE A COUPLE OF CATEGORIES");
			Category romanceCat = new Category("Romance");
			Category poetryCat =  new Category("Poetry");
			Category fantasyCat = new Category("Fantasy");
			
			catrepo.save(romanceCat);
			catrepo.save(poetryCat);
			catrepo.save(fantasyCat);
			
			
			//Creating users
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@user.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@admin.com","ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("SAVE A COUPLE OF BOOKS");
			
			bookRepository.save(new Book("ISBN9876T", "Zzzzz", "Maija Mehiläinen", 1989, 5.99, romanceCat));
			bookRepository.save(new Book("ISBN54321V", "Elämäni muro", "Matti Mörökölli", 1902, 399.99, poetryCat));
			bookRepository.save(new Book("ISBN12345Y", "The Talking Hat", "Luna Lovekiva", 2001, 19.99, fantasyCat));
			
			log.info("FETCH ALL BOOKS");
			for (Book book: bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
		
	}
}
	


