package com.workit.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.workit.bean.Car;
import com.workit.config.MainConfigOfLifeCycle;

public class IOCTest_LifeCycle {
	@Test
	public void test01(){
		//第一步，创建ioc容器
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建完成。。。。。。");
		//当多实例的时候，获取bean的时候会创建对象，并调用init方法
		//annotationConfigApplicationContext.getBean("car");
		//关闭容器
		annotationConfigApplicationContext.close();
	}
}
