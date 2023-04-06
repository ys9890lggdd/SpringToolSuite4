package com.itwill.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itwill.user.mapper.UserMapper;

@SpringBootApplication
@MapperScan
//@MapperScan(basePackages = "com.itwill.user.mapper")
@MapperScan(basePackageClasses =UserMapper.class)
public class UserSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserSpringApplication.class, args);
	}

}
