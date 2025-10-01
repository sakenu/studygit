package com.study.project.controller;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.project.service.LoginServiceInter;


@Controller
public class LoginController {
	
	@Autowired
	public LoginServiceInter service;
	
	//mapper.xml --- select
	@RequestMapping("login") // 404 
	@ResponseBody
	public List<Map<String, Object>> login(){
//					{"password" : "1111"}
		//빈 그릇
		List<Map<String, Object>> loginList = service.login();
				
			
		return loginList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
