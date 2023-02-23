package com.itwill.datasource;

import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.guest.dao.jdbc.GuestDao;
@SpringBootTest
class SpringBootDataSourceApplicationMainTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	GuestDao guestDao;
	
	@Test
	void contextLoad() {
		
	}
	@Test
	void dataSource()  throws Exception {
		System.out.println("1.DataSource:"+dataSource);
		System.out.println("2.Connection:"+dataSource.getConnection());
	}
	
	

}