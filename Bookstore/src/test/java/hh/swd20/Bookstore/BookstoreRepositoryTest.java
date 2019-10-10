package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookstoreRepositoryTest {
	

	@Autowired
	private BookRepository repository;
	
	@Test //create
	public void createNewBook() {
		Book book = new Book("ISBN666966", "Fun times with Frank", "Frankey Frankster", 2015, 10.95, new Category("khhfdg"));
		//the last part doesn't work. Category = null
		repository.save(book);
		assertThat(book.getIsbn()).isNotNull();
	}
	
	@Test //TODO delete book -test
	public void deleteBook() {
		
	}
	
	@Test //TODO search book -test
	public void findByNameShouldReturnBook() {
		
	}

}
