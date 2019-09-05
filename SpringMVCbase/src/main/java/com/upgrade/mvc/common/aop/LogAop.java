package com.upgrade.mvc.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class LogAop {
	
	@Pointcut("execution(public * com.upgrade.mvc.model.dao.*Dao*.*(..))")
	public void allTarget() {};
	
	@Before("allTarget()")
	public void before(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		
		logger.info("======logger start=======");
		Object args[] = join.getArgs();
		if(args != null) {
			logger.info("Method : " + join.getSignature().getName());
			for (int i = 0; i < args.length; i++) {
				logger.info(i+"번째"+args[i]);
			}
		}
	}
	@After("allTarget()")
	public void after(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("-------------logger end=======");
	}
	
	@AfterThrowing("allTarget()")
	public void afterThrowing(JoinPoint join) {
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("error : "+ join.getArgs());
		logger.info("error : "+ join.toString());
	}
}
