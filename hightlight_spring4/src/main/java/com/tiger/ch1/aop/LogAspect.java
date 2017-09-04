package com.tiger.ch1.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 切面
 * @author yue
 *
 */
@Aspect
@Component
public class LogAspect {
	@Pointcut("@annotation(com.tiger.ch1.aop.Action)")
	public void annotationPointCut(){}
	@After("annotationPointCut()")
	public void after(JoinPoint joinPoint){
		// 通过反射获得注解上的属性
		MethodSignature s = (MethodSignature)joinPoint.getSignature();
		Method method = s.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("注解式拦截："+action.name());
	}
	@Before("execution(* com.tiger.ch1.aop.DemoMethodService.*(..))")
	public void before(JoinPoint joinPoint){
		// 通过反射获得方法名，可以直接输出
		MethodSignature s = (MethodSignature)joinPoint.getSignature();
		Method method = s.getMethod();
		System.out.println("方法规则拦截："+method.getName());
	}
}
