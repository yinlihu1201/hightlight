package com.tiger;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.tiger.interceptor.DemoInterceptor;
import com.tiger.messageconverter.MyMessageConverter;

@Configuration
@ComponentScan("com.tiger")
@EnableWebMvc
@EnableScheduling
public class MyMvcConfig extends WebMvcConfigurerAdapter {
	/**
	 * 配置一个JSp的viewResolver，用来映射路径和实际页面的位置
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 访问路径为/asset/  路径为classpath:/asset/
		registry.addResourceHandler("/asset/**").addResourceLocations("classpath:/asset/");
	}
	@Bean
	public DemoInterceptor demoInteceptor(){
		return new DemoInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInteceptor());
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("/index");
		registry.addViewController("/toUpload").setViewName("/upload");
		registry.addViewController("/converter").setViewName("/converter");
		registry.addViewController("/sse").setViewName("/sse");
		registry.addViewController("/async").setViewName("/async");
	}
	@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver mul = new CommonsMultipartResolver();
		mul.setMaxUploadSize(1000000);
		mul.setDefaultEncoding("utf-8");
		return mul;
	}
	/**
	 * 注册自定义的HttpMessageConverter
	 * @param converters
	 */
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(myMessageConverter());
	}
	@Bean
	public MyMessageConverter myMessageConverter(){
		return new MyMessageConverter();
	}
	
}
