package com.tiger.ch2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
/**
 * 监听事件
 * @author yue
 *
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
	/**
	 * 对消息进行处理
	 */
	public void onApplicationEvent(DemoEvent event) {
		String msg = event.getMsg();
		System.out.println("我（bean-demoListener）接受到了bean-demoPublisher发布的消息："+msg);
	}

}
