package com.koscom.microservices.user.model;

import lombok.Data;

@Data // lombok 사용을 위해 추가해야 함 
public class User {

	private Integer id;
	private Integer customerId;
	private String number;


	public User(Integer id, Integer customerId, String number) {
		this.id = id;
		this.customerId = customerId;
		this.number = number;
	}


}
