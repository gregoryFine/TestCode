package com.ln.entity;

import java.io.Serializable;

public class Order implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4555149562709752973L;

	private String id;
	
	private String name;
	
	private String messageId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public Order() {
		super();
	}
	
	public Order(String id, String name, String messageId) {
		this.id = id;
		this.name = name;
		this.messageId = messageId;
	}

	
	
	

}
