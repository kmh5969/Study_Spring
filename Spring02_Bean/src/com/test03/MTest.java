package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext beans = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		
		UserService service = beans.getBean("service", UserServiceImpl.class);
		
		UserDto dto = beans.getBean("dto", UserDto.class);
		System.out.println(dto.getName());
		System.out.println(dto.getMydate());
		service.addUser(dto);
		
		// 1. beans.xml에서 UserDto 객체를 만들자.
		
		// 2. MTest에서 service.addUser() argument로 1번에서 만든 객체를 넣어주자
		
	}

}
