package com.tiger.ch2.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
		// DemoPublisher通过ApplicationContext发布事件DemoEvent，DemoListener监听DemoEvent事件
		DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
		demoPublisher.publisher("hello application event");
		context.close();
	}
}
