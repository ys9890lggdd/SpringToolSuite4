package com.itwill.user.dao.jdbctemplate;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.function.Supplier;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;


@SpringBootApplication
@SpringBootTest
class UserDaoImplJdbcTemplateTest {
	Logger logger=LoggerFactory.getLogger(UserDaoImplJdbcTemplate.class);
	
	@Autowired
	UserDao userDao;
	@Transactional
	@Test
	void testCreate() {
		User user=new User("jdbctemplate34", "1111", "제이디비씨", "jdbc@jdbc.com");
		try {
			int rowCount = userDao.create(user);
			assertEquals(rowCount, 1,"insert success");
			
		} catch (Exception e) {
			//fail(e.getMessage());
			assertInstanceOf(DuplicateKeyException.class,e);
		}
		
	}
	
	@Disabled
	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testRemove() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testFindUser() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testFindUserList() {
		fail("Not yet implemented");
	}
	@Disabled
	@Test
	void testExistedUser() {
		fail("Not yet implemented");
	}

}
