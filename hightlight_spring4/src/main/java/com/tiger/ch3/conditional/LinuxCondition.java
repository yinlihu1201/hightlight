package com.tiger.ch3.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
/**
 * Linux判断条件
 * @author yue
 *
 */
public class LinuxCondition implements Condition{

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata arg1) {
		return context.getEnvironment().getProperty("os.name").contains("Linux");
	}

}
