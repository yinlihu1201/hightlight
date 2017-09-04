package com.tiger.ch1.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 配置类
 * @author yue
 *
 */
@Configuration
@ComponentScan("com.tiger.ch1.aop")
@EnableAspectJAutoProxy
public class AopConfig {

}
