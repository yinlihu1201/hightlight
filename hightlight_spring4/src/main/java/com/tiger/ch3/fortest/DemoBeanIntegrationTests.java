package com.tiger.ch3.fortest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
@ActiveProfiles("prod")
public class DemoBeanIntegrationTests {
	@Autowired
	private TestBean testBean;
	@Test
	public void prodBeanShouldInject(){
		String expectStr = "for product profile";
		String actualStr = testBean.getContext();
		System.out.println(actualStr);
		Assert.assertEquals(expectStr, actualStr);
	}
}
