package com.tiger.ch3.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
		// 这里不能关闭，如果关闭，计划任务就不存在了
	}
}
