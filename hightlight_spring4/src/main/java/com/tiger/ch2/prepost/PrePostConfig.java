package com.tiger.ch2.prepost;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 分别是在构造实例之后，以及销毁之前进行操作
 * @author yue
 *
 */
@Configuration
@ComponentScan("com.tiger.ch2.prepost")
public class PrePostConfig {
	@Bean(initMethod="init",destroyMethod="destroy")
	BeanWayService beanWayService(){
		return new BeanWayService();
	}
	@Bean
	JSR250WayService jsr250WayService(){
		return new JSR250WayService();
	}
}
