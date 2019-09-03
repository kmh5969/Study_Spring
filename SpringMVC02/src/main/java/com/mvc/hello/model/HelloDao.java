package com.mvc.hello.model;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {
	
	public String getHello() {
		
		return "spring";
	}
	
	public String getBye(String name) {
		
		return name;
	}

}
