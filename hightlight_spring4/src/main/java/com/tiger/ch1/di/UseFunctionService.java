package com.tiger.ch1.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {
	@Autowired
	FunctionService fs;
	
	public String sayHello(String word){
		return fs.sayHello(word);
	}
}
