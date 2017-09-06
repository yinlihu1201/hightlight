package com.tiger.ch3.aware;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * Spring Aware演示bean
 * @author yue
 *
 */
@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware{
	private String beanName;
	private ResourceLoader loader;
	public void setResourceLoader(ResourceLoader loader) {
		this.loader = loader;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	
	public void outputResult(){
		System.out.println("beanName:"+beanName);
		Resource resource = loader.getResource("classpath:com/tiger/ch3/aware/test.txt");
		try {
			System.out.println("ResourceLoader加载的文件内容为："+IOUtils.toString(resource.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
