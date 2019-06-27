package com.ln.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ln.dao.OrderStoreMapper;
import com.ln.entity.Order;
import com.ln.service.OrderStoreService;

@Service
public class OrderStoreServiceImpl implements OrderStoreService {
	
	@Autowired
	private OrderStoreMapper orderStoreMapper;

	@Override
	public void storeOrder(Order order) {
		orderStoreMapper.storeOrder(order);
	}

}
