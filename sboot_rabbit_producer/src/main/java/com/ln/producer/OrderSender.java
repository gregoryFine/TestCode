package com.ln.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ln.entity.Order;

@Component
public class OrderSender {

	Logger logger = LoggerFactory.getLogger(OrderSender.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendOrder(Order order) throws Exception {

		CorrelationData correlationData = new CorrelationData();
		correlationData.setId(order.getMessageId());
		
		rabbitTemplate.convertAndSend("order-exchange",//exchange
				"order.abcd",//routing-key
				order,//消息內容
				correlationData);//消息唯一id
		logger.info("------------------------生产一条消息 ---------------------------");
	}

}
