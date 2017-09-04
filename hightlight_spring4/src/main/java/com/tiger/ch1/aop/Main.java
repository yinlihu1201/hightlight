package com.tiger.ch1.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		DemoAnnotationService da = context.getBean(DemoAnnotationService.class);
		DemoMethodService dm = context.getBean(DemoMethodService.class);
		da.add();
		dm.add();
		context.close();
	}
}
