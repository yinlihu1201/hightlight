package com.tiger.ch3.conditional;
/**
 * Windows下的Bean
 * @author yue
 *
 */
public class WindowsListService implements ListService{

	public String showListCmd() {
		return "dir";
	}

}
