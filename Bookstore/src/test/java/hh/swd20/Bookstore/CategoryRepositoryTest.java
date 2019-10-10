package hh.swd20.Bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository repository;
	
	// Test create, delete and search functionalities
	
	@Test //TODO create category -test
	public void createNewCategory() {

	}
	
	@Test //TODO delete category -test
	public void deleteCategory() {
		
	}
	
	@Test //TODO search category -test
	public void findByCategoryShouldReturnBook() {
		
	}

}
