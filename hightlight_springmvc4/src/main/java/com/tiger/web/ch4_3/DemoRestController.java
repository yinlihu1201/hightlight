package com.tiger.web.ch4_3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiger.domain.DemoObj;

@RestController
@RequestMapping("/rest")
public class DemoRestController {
	@RequestMapping(value="/getjson",produces={"application/json;chartset=utf-8"})
	public DemoObj getJson(DemoObj obj){
		return new DemoObj(obj.getId()+1,obj.getName()+"yy");
	}
	
	@RequestMapping(value="/getxml",produces={"application/xml;chartset=utf-8"})
	public DemoObj getXml(DemoObj obj){
		return new DemoObj(obj.getId()+1,obj.getName()+"yy");
	}
}
