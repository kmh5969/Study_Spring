package com.test01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
	
	@Before("execution(public * sayName(..))")
	public void beforeSaying(JoinPoint join) {
		System.out.println("당신의 이름은 무엇입니까?");
	}
	
	@After("execution(public * sayJob(..))")
	public void afterSaying(JoinPoint join) {
		System.out.println("이름이 멋지시네요");
		System.out.println("직업이 무엇입니까?");
	}
	
	@AfterReturning(pointcut = "execution(public String com.test01.Person.*(..))", returning = "returnVal")
	public void afterReturnSaying(JoinPoint join, Object returnVal) {
		System.out.println(returnVal);
	}

}
