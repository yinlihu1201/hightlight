package com.tiger.messageconverter;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import com.tiger.domain.DemoObj;

public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

	public MyMessageConverter() {
		// 新建一个自定义的媒体类型application/wisely
		super(new MediaType("application","x-wisely",Charset.forName("UTF-8")));
	}
	/**
	 * 重写readInternal方法，处理请求数据
	 */
	@Override
	protected DemoObj readInternal(Class<? extends DemoObj> arg0,
			HttpInputMessage arg1) throws IOException,
			HttpMessageNotReadableException {
		String temp = StreamUtils.copyToString(arg1.getBody(), Charset.forName("UTF-8"));
		String[] tempArr = temp.split("-");
		return new DemoObj(new Long(tempArr[0]),tempArr[1]);
	}
	/**
	 * 表明本类只处理DemoObj这个类
	 */
	@Override
	protected boolean supports(Class<?> arg0) {
		return DemoObj.class.isAssignableFrom(arg0);
	}
	/**
	 * 处理如何输出数据到response
	 */
	@Override
	protected void writeInternal(DemoObj obj, HttpOutputMessage arg1)
			throws IOException, HttpMessageNotWritableException {
		String out = "hello :" + obj.getId()+"-"+obj.getName();
		arg1.getBody().write(out.getBytes());
	}

}
