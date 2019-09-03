package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	// TODO : 004. service 객체의 addUser 호출
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/beans.xml");
		
		UserService us = factory.getBean("userService", UserService.class);
		us.addUser();
		int a = 1;
		for(int i = 10; i > 0; i--) {
			System.out.println(a *= i);
		}
	}

}
