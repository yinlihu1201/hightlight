package com.tiger.ch1.aop;

import org.springframework.stereotype.Service;
/**
 * 方法规则被拦截类
 * @author yue
 *
 */
@Service
public class DemoMethodService {
	public void add(){
		System.out.println("add2");
	}
}
