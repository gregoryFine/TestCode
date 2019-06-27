package com.ln.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ln.entity.Order;
import com.ln.producer.OrderSender;

@Service
public class FirstService {
	
	@Autowired
	private OrderSender orderSender;
	
	/**
	 * 向rabbitmq生产消息
	 */
	public String onlyToSend() {
		String orderStr = "";
		try {
			Order order = new Order();
			order.setId("20190627" + UUID.randomUUID());
			order.setName("测试消息1");
			order.setMessageId(System.currentTimeMillis()+"$"+UUID.randomUUID());
			Gson g = new Gson();
			orderStr = g.toJson(order);
			orderSender.sendOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderStr;
	}
	
}
