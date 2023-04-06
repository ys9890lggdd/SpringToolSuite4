package com.mybatis3.dao;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import com.mybatis3.dao.mapper.StudentMapper;
@MybatisTest
class StudentDaoTest {
	@Autowired
	StudentMapper studentMapper;
	@Test
	void test() {
		System.out.println(studentMapper);
	}

}
