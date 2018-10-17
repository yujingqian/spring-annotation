package com.workit.bean;

import org.springframework.stereotype.Component;

@Component
public class Dog {

	public Dog(){
		System.out.println("dog.....constructor....");
	}
	
	
	public void init(){
		System.out.println("dog....init.....");
	}
}
