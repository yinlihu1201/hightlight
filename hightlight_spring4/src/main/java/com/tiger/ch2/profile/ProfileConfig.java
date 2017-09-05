package com.tiger.ch2.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * profile为dev时，实例化devDemoBean
 * @author yue
 *
 */
@Configuration
@ComponentScan("com.tiger.ch2.profile")
public class ProfileConfig {
	@Bean
	@Profile("dev")
	public DemoBean devDemoBean(){
		return new DemoBean("from development profile");
	}
	@Bean
	@Profile("prod")
	public DemoBean proDemoBean(){
		return new DemoBean("from production profile");
	}
}
