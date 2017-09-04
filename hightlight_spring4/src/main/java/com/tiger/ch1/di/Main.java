package com.tiger.ch1.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
		UseFunctionService ufs = context.getBean(UseFunctionService.class);
		System.out.println(ufs.sayHello("world"));
		context.close();
	}
}
