package hh.swd20.Bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.Bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	// Test create, delete and search functionalities
	
	@Test //TODO create  user -test
	public void createNewUser() {

	}
	
	@Test //TODO delete  user -test
	public void deleteUser() {
		
	}
	
	@Test //TODO search user -test
	public void findByUsernameShouldReturnUser() {
		
	}

}
