package com.ln;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ln.entity.Order;
import com.ln.producer.OrderSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbootRabbitApplicationTests {
	

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private OrderSender orderSender;
	
	@Test
	public void sendTest1() throws Exception {
		Order order = new Order();
		order.setId("20190627" + UUID.randomUUID());
		order.setName("测试消息1");
		order.setMessageId(System.currentTimeMillis()+"$"+UUID.randomUUID());
		orderSender.sendOrder(order);
	}

}
