package com.app.aspects;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.app.pojo.Employee;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class Aspects {

//	Logger log  = LoggerFactory.getLogger(getClass()); //if lombok dosent works then this can be used

	@Before(value = "execution(* com.app.controller.*.*(..))")
	public void beforeAspect(JoinPoint joinPoint) {
		System.out.println("Inside Before Aspect");
		System.out.println("called" + joinPoint.getSignature() + "method ");
		log.info("called method");

	}

	@After(value = "execution( * com.app.controller.*.*(..))")
	public void afterAspect(JoinPoint joinPoint) {
		System.out.println("In after aspect ...method called " + joinPoint.getSignature() + new Date());
	}

	@Around(value = "execution(* com.app.service.*.*(..))")
	public Object aroundAspect(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Inside Around Aspect ...method Processing  started at : " + new Date());
		Object result;
		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {
			System.out.println("Failed to process the method!!!");
			throw e;

		}
		System.out.println("Inside Around Aspect ...Method processing successfull at : " + new Date());
		return result;
	}

	@AfterReturning(value = "execution( * com.app.controller.*.*(..))", returning = "emp")
	public void afterReturning(JoinPoint joinPoint, Employee emp) {
		System.out.println("Inside afterReturning aspect " + new Date());
	}

	@AfterThrowing(value = "execution( * com.app.controller.*.*(..))", throwing = "exception")
	public void afterThrowingAspect(JoinPoint joinPoint, Exception exception) {
		System.out.println("Inside afterThrowing aspect " + exception.getMessage() + new Date());
	}
}
