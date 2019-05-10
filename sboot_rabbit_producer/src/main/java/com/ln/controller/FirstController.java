package com.ln.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/first")
public class FirstController {
	
	Logger logger = LoggerFactory.getLogger(FirstController.class);
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello bootRabbit";
	}
	
	@RequestMapping("/toFirstJsp")
	public String toFirstJsp() {
		logger.info("---------------------------------------toFirstJsp------------------------------------------");
		return "first/first";
	}
}
