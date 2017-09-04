package com.tiger.ch1.javaconfig;


public class UseFunctionService {
	
	FunctionService fs;
	
	public void setFs(FunctionService fs) {
		this.fs = fs;
	}
	
	public String sayHello(String word){
		return fs.sayHello(word);
	}
}
