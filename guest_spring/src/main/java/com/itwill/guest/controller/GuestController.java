package com.itwill.guest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class GuestController {
	public GuestController() {
		System.out.println(">>>GuestController");
	}
	@RequestMapping("/guest_main")
	public String guest_main() {
		String forwardPath = "guest_main";
		return forwardPath;
	}
	public String guest_list() {
		String forwardPath = "";
		return forwardPath;
	}
	public String guest_error() {
		String forwardPath = "";
		return forwardPath;
	}
	
	public String guest_modify_action() {
		String forwardPath = "";
		return forwardPath;
	}
	

	public String guest_modify_form() {
		String forwardPath = "";
		return forwardPath;
	}
	
	public String guest_remove_action() {
		String forwardPath = "";
		return forwardPath;
	}
	
	public String guest_view() {
		String forwardPath = "";
		return forwardPath;
	}
	
	public String guest_write_action() {
		String forwardPath = "";
		return forwardPath;
	}
	public String guest_write_form() {
		String forwardPath = "";
		return forwardPath;

	}
	
	@GetMapping(value = {"guest_modify_form",
						"guest_modify_action",
						"guest_write_action",
						"guest_remove_action"})
	public String guest_get() {
		String forwardPath = "redirect:guest_main";
		return forwardPath;
	}
	/*
	public String guest_modify_form_get() {
		String forwardPath = "";
		return forwardPath;
	}
	public String guest_modify_action_get() {
		String forwardPath = "";
		return forwardPath;
	}
	public String guest_write_action_get() {
		String forwardPath = "";
		return forwardPath;
	}
	public String guest_remove_action_get() {
		String forwardPath = "";
		return forwardPath;
	}
	*/

}