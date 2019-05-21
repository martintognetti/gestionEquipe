package com.fr.adaming.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.entity.User;

@RunWith (SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTests {
	
	@Autowired
	private IUserService service;
	
	private static User result;
	
	
	@Test
	public void aa_createValidUser() {
		User testUser = new User(null, "nom", "prenom", "email@gmail.com", "pwd1234", null);
		
		result = service.create(testUser);
//		System.out.println("DEBUG USER ID AFTER CREATION : " +result.getId());
		assertNotNull("L'id du user créé est à null", result.getId());
	}
	
	
	@Test(expected = DataIntegrityViolationException.class)
	public void ab_createUnvalidUser() {
		
		aa_createValidUser();
		User testUser2 = new User(null, "updatenom", "updateprenom", "email@gmail.com", "pwd1234", null);
		
		service.create(testUser2);
		System.out.println("DEBUG USER ID AFTER CREATION : " +result);
//		assertNull(result);
//		service.delete(testUser);
//		service.delete(testUser2);
	}
	
	
	@Test
	public void ac_deleteUser() {
		aa_createValidUser();
		boolean test = service.delete(result);
		System.out.println("DEBUG est supprimé ? : " + test);
		assertTrue(test);
		
	}
	
	@Test
	public void ad_readByIdValid() {
		User test = null;
		aa_createValidUser();
		test = service.readById(result.getId());
		assertNotNull("L'objet user est null", test);
		
	}
	
	@Ignore
	public void ae_readBiIdUnvalid() {
		
	}
	
	@Before
	public void beforeMethod() {
		System.out.println("\n********** Start a new method **********\n");
	}
	
	@After
	public void afterMethod() {
		System.out.println("\n********** End of the method **********\n");
		if (result != null) {
			service.delete(result);		
		}
	}

}
