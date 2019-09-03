package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext beans = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");
		Developer you = beans.getBean("you", Developer.class);
		Engineer kang = beans.getBean("kang", Engineer.class);
		
		System.out.println(you);
		System.out.println(kang);
	}

}
