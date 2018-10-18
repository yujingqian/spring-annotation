package com.workit.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Dog implements ApplicationContextAware{
	//@Autowired
	private ApplicationContext applicationContext;
	
	public Dog(){
		System.out.println("dog.....constructor....");
	}
	
	
	public void init(){
		System.out.println("dog....init.....");
	}


	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}
}
