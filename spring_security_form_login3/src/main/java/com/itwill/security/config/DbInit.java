package com.itwill.security.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itwill.security.user.domain.Users;
import com.itwill.security.user.service.UsersService;

@Component
public class DbInit implements InitializingBean {

	@Autowired
	private UsersService userService;

	@Override
	public void afterPropertiesSet() throws Exception {
		
		if (!userService.findUser("user@test.com").isPresent()) {
			Users users1 = userService
					.save(Users.builder().email("user1").password("1111").enabled(true).build());			
			userService.addAuthority(users1.getUserId(), "ROLE_USER");	
		}
		
		if (!userService.findUser("user@test.com").isPresent()) {			
			Users users2 = userService
					.save(Users.builder().email("user2").password("2222").enabled(true).build());			
			userService.addAuthority(users2.getUserId(), "ROLE_USER");
			userService.addAuthority(users2.getUserId(), "ROLE_ADMIN");
			
		}

	}

}
