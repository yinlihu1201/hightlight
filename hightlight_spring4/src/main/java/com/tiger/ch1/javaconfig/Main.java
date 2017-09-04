package com.tiger.ch1.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		UseFunctionService u = context.getBean(UseFunctionService.class);
		System.out.println(u.sayHello("world"));
		context.close();
	}
}
