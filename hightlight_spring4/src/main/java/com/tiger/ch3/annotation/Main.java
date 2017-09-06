package com.tiger.ch3.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		DemoService bean = c.getBean(DemoService.class);
		bean.outputResult();
		c.close();
	}
}
