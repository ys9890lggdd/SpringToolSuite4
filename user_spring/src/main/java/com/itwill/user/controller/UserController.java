package com.itwill.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.user.UserService;
/*
 * /user_main 
 * /user_write_form 
 * /user_write_action 
 * /user_login_form
 * /user_login_action 
 * /user_logout_action 
 * /user_view /user_modify_form
 * /user_modify_action 
 * /user_remove_action
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user_main")
	public String user_main() {
		return "user_main";
	}
	@RequestMapping("/user_write_form")
	public String user_write_form() {
		String forward_path = "user_write_form";
		return forward_path;
	}
    @PostMapping("user_write_action")
	public String user_write_action_post() throws Exception {
		String forward_path = "";
		
		
		
		
		
		return forward_path;
	}

	public String user_login_form() {
		String forward_path = "";
		return forward_path;
	}

	public String user_login_action_post() throws Exception {
		String forwardPath = "";
		return forwardPath;
	}
	

	public String user_view() throws Exception {
		/************** login check **************/
		String forwardPath = "";
		return forwardPath;
	}


	public String user_modify_form_post() throws Exception {
		/************** login check **************/

		String forwardPath = "";

		return forwardPath;
	}

	public String user_modify_action_post() throws Exception {
		/************** login check **************/
		String forwardPath = "";
		return forwardPath;
	}

	public String user_remove_action_post() throws Exception {
		/************** login check **************/
		String forwardPath = "";
		return forwardPath;
	}

	public String user_logout_action(HttpSession session) {
		/************** login check **************/
		String forwardPath = "";
		return forwardPath;
	}
	
	/***********GET방식요청시guest_main redurection**********/
	@GetMapping({
		        "user_write_action",
		
	            })

	public String user_get() {
		String forwardPath = "";
		return forwardPath;
	}


}
