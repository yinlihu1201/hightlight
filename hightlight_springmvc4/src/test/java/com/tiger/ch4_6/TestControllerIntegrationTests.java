package com.tiger.ch4_6;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.tiger.MyMvcConfig;
import com.tiger.service.DemoService;
/**
 * TDD:测试驱动开发
 * @author yue
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MyMvcConfig.class})
@WebAppConfiguration("src/main/resource")
public class TestControllerIntegrationTests {
	private MockMvc mocMvc;
	@Autowired
	private DemoService demoService;
	@Autowired
	WebApplicationContext wac;
	@Autowired
	MockHttpSession session;
	@Autowired
	MockHttpServletRequest request;
	@Before
	public void setup(){
		this.mocMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	@Test
	public void testNormalController() throws Exception{
		mocMvc.perform(MockMvcRequestBuilders.get("/normal"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("page"))
		.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/classes/views/page.jsp"))
		.andExpect(MockMvcResultMatchers.model().attribute("msg", demoService.saySomething()));
	}
	@Test
	public void testRestController() throws Exception{
		mocMvc.perform(MockMvcRequestBuilders.get("/testRest"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=utf-8"))
		.andExpect(MockMvcResultMatchers.content().string( demoService.saySomething()));
	}
}
