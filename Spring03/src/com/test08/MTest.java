package com.test08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		ApplicationContext beans = new ClassPathXmlApplicationContext("com/test08/beans.xml");
		
		SamsongTV samsong = beans.getBean("samsong", SamsongTV.class);
		samsong.powerOn();
		samsong.powerOff();
		samsong.volumeUp();
		samsong.volumeDown();
		
		LzTV lz = beans.getBean("lz", LzTV.class);
		lz.powerOn();
		lz.powerOff();
		lz.volumeUp();
		lz.volumeDown();
	}

}
