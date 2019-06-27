package com.ln.consumer;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*; //此引入可引入所有annotation标签，要不然@QueueBinding 等标签无法引到
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ln.entity.Order;
import com.ln.service.OrderStoreService;
import com.rabbitmq.client.Channel;

@Component
public class OrderReceiver {
	
	Logger logger = LoggerFactory.getLogger(OrderReceiver.class);

	@Autowired
	private OrderStoreService orderStoreService;
	
	
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(value ="order-queue", durable="true"),
			exchange = @Exchange(value ="order-exchange", durable="true", type="topic"),
			key = "order.*"
		)
	)
	@RabbitHandler
	public void onMessageReceiver(@Payload Order order, //消息主体
			@Headers Map<String, Object> headers, // 头部信息
			Channel channel // 手工签收必须使用channel 用于产生ACK
			) throws Exception {
		logger.info("-------------------------------收到消息，开始消费a----------------------------------------------");
		String id = order.getId();
		logger.info("消息ID为：" + id);
		//手工签收必须用到channel,产生ACK，相当于对rabbit产生响应
		Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
		channel.basicAck(deliveryTag, false);//false表示不接受批量接受
		
		orderStoreService.storeOrder(order);
		
	}
	
}
