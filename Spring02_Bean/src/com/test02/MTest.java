package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/beans.xml");
		
		Address hong = (Address) factory.getBean("hong");
		Address lee = (Address) factory.getBean("lee");
		Address kim = (Address) factory.getBean("kim");
		
		System.out.println(hong);
		System.out.println(lee);
		System.out.println(kim);
		
		ApplicationContext beans = new ClassPathXmlApplicationContext("com/test02/beans.xml");
		
		JobAdress jHong = (JobAdress)beans.getBean("jHong");
		JobAdress jLee = (JobAdress)beans.getBean("jLee");
		JobAdress jKim = (JobAdress)beans.getBean("jKim");
		
		System.out.println(jHong);
		System.out.println(jLee);
		System.out.println(jKim);
		
	}

}
