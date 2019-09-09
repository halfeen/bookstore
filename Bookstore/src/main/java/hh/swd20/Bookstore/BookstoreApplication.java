package hh.swd20.Bookstore;


import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

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
	public CommandLineRunner bookDemo(BookRepository bookRepository) {
		return (args) -> {
			log.info("SAVE A COUPLE OF BOOKS");
			bookRepository.save(new Book("abcdefg1", "Joku titteli", "Maija Mehiläinen", 1901, 2.99));
			bookRepository.save(new Book("abcdefg2", "Joku titteli2", "Matti Mehiläinen", 1902, 3.99));
			
			log.info("FETCH ALL BOOKS");
			for (Book book: bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
		
	}
}
	


