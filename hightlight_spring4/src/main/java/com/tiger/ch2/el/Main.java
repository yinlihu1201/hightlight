package com.tiger.ch2.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
		ElConfig c = context.getBean(ElConfig.class);
		c.outputResource();
		context.close();
	}
}
