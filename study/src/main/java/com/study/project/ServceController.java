package com.study.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServceController {
	
	@RequestMapping("test1")
	public String test1() {
		return "testJsp";
	}

}
