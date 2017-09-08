package com.tiger.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
/**
 * 添加全局信息
 * @author yue
 *
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
	/**
	 * 所有的Exception都转到这里，跳转到error.jsp
	 * @param exception
	 * @param webRequest
	 * @return
	 */
	@ExceptionHandler(value=Exception.class)
	public ModelAndView exception(Exception exception,WebRequest webRequest){
		ModelAndView modelAndView = new ModelAndView("error");// error 页面
		modelAndView.addObject("errorMessage",exception.getMessage());
		return modelAndView;
	}
	@ModelAttribute
	public void addAttribute(Model model){
		model.addAttribute("msg","额外信息");
	}
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.setDisallowedFields("id");//忽略request参数的id
	}
}
