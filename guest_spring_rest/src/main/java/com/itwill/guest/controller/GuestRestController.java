package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

import io.swagger.annotations.ApiOperation;
/*
1. GET    - /guest : 모든 데이터를 요청한다.
2. POST   - /guest : 데이터를 추가한다.
3. GET    - /guest/n : n번째 데이터를 요청한다.
4. PUT    - /guest/n : n번째 데이터를 수정한다.
5. DELETE - /guest/n : n번째 데이터를 제거한다.
*/
@RestController
public class GuestRestController {
	@Autowired
	private GuestService guestService;
	
	@ApiOperation(value = "방명록")
	@PostMapping(value = {"/"},
			produces = "application/json;charset=UTF-8")
	public Map<String,Object> guest_json() {
		Map<String,Object> resultMap=new HashMap<String,Object>();
		int code=1;
		String msg="메세지";
		List<Guest> data=new ArrayList<Guest>();
		String url="";
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",data);
		return resultMap;
	}

	public Map<String,Object> guest_list_json() {
		Map<String,Object> resultMap=new HashMap<String,Object>();
		int code=1;
		String msg="메세지";
		List<Guest> data=new ArrayList<Guest>();
		String url="";
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",data);
		return resultMap;
	}
	
	public Map<String,Object> guest_detail_json() {
		Map<String,Object> resultMap=new HashMap<String,Object>();
		int code=1;
		String msg="메세지";
		List<Guest> data=new ArrayList<Guest>();
		String url="";
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",data);
		return resultMap;
	}
	
	public Map<String,Object> guest_write_action_json() {
		Map<String,Object> resultMap=new HashMap<String,Object>();
		int code=1;
		String msg="메세지";
		List<Guest> data=new ArrayList<Guest>();
		String url="";
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",data);
		return resultMap;
	}
	
	public Map<String,Object> guest_modify_action_json() {
		Map<String,Object> resultMap=new HashMap<String,Object>();
		int code=1;
		String msg="메세지";
		List<Guest> data=new ArrayList<Guest>();
		String url="";
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",data);
		return resultMap;
	}
	
	public Map<String,Object> guest_modify_form_json() {
		Map<String,Object> resultMap=new HashMap<String,Object>();
		int code=1;
		String msg="메세지";
		List<Guest> data=new ArrayList<Guest>();
		String url="";
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",data);
		return resultMap;
	}
	
	public Map<String,Object> guest_remove_action_json() {
		Map<String,Object> resultMap=new HashMap<String,Object>();
		int code=1;
		String msg="메세지";
		List<Guest> data=new ArrayList<Guest>();
		String url="";
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data",data);
		return resultMap;
	}
	
	
	
	
	
	
	

}
