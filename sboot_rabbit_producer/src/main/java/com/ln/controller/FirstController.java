package com.ln.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ln.service.FirstService;

@Controller
@RequestMapping("/first")
public class FirstController {
	
	Logger logger = LoggerFactory.getLogger(FirstController.class);
	
	@Autowired
	private FirstService firstService;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello bootRabbit";
	}
	
	@RequestMapping("/toFirstJsp")
	public String toFirstJsp() {
		return "first/first";
	}
	
	/**
	 * 向rabbitmq生产消息
	 * @return
	 */
	@RequestMapping("/toProduce")
	@ResponseBody
	public String toProduce() {
		String orderStr = firstService.onlyToSend();
		return orderStr;
	}
}
