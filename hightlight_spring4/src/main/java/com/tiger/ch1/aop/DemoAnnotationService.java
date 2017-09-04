package com.tiger.ch1.aop;

import org.springframework.stereotype.Service;
/**
 * 注解规则的被拦截类
 * @author yue
 *
 */
@Service
public class DemoAnnotationService {
	@Action(name="注解式拦截的add操作")
	public void add(){
		System.out.println("add1");
	};
}
