package com.workit.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
	
@Component
public class Cat implements InitializingBean,DisposableBean{
	public Cat(){
		System.out.println("cat constructor.....");
	}
	//销毁方法
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("cat......destory.....");
	}
	//初始化方法S
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("cat......afterPropertiesSet.....");
	}
}
