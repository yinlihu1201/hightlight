package com.tiger.ch3.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(ConditionConfig.class);
		ListService bean = c.getBean(ListService.class);
		System.out.println(c.getEnvironment().getProperty("os.name")+"系统下的列表命令为"+bean.showListCmd());
		c.close();
	}
}
