package com.tiger.ch2.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
/**
 * 事件发布类
 * @author yue
 *
 */
@Component
public class DemoPublisher {
	@Autowired
	ApplicationContext applicationContext;
	
	public void publisher(String msg){
		// 发布一个事件
		applicationContext.publishEvent(new DemoEvent(this, msg));
	}
}	
