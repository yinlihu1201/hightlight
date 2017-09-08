package com.tiger.web.ch4_5;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SseController {
	/**
	 * produces指定的输出的媒体类型，这是SSE的支持，演示每5秒向浏览器推送随机消息
	 * @return
	 */
	@RequestMapping(value="/push",produces="text/event-stream")
	@ResponseBody
	public String push(){
		Random r = new Random();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "data:Testing 1,2,3"+r.nextInt()+"\n\n";
	}
}
