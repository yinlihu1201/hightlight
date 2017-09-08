package com.tiger.web.ch4_6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiger.service.DemoService;

@RestController
public class MyRestController {
	@Autowired
	DemoService demoService;
	@RequestMapping(value="/testRest",produces="text/plain;charset=utf-8")
	public String testRest(){
		return demoService.saySomething();
	}
}
