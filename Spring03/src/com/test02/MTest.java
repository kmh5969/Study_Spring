package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext beans = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		// 1. 왼쪽 짝궁의 이름과 생일을 setter를 사용하여 값을 주입하고 출력
		BirthDto yeong = beans.getBean("Yeong", BirthDto.class);
		System.out.println(yeong);
		
		// 2. 오른쪽 짝궁의 이름과 생일을 생성자를 사용하여 값을 주입하고 출력
		BirthDto beom = beans.getBean("Beom",  BirthDto.class);
		System.out.println(beom);
		
		// 3. 내 이름과 생일을 (마음대로) 값을 주입하고 출력
		BirthDto hoon = beans.getBean("Hoon",  BirthDto.class);
		System.out.println(hoon);
	}

}
