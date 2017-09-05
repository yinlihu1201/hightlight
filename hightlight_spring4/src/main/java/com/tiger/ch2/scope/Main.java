package com.tiger.ch2.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
		DemoSingleService s1 = context.getBean(DemoSingleService.class);
		DemoSingleService s2 = context.getBean(DemoSingleService.class);
		
		DemoPrototypeService p1 = context.getBean(DemoPrototypeService.class);
		DemoPrototypeService p2 = context.getBean(DemoPrototypeService.class);
		
		System.out.println(s1 == s2);
		System.out.println(p1 == p2);
		context.close();
	}
}
