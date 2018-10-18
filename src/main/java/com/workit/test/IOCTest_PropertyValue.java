package com.workit.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.workit.bean.Car;
import com.workit.bean.Person;
import com.workit.config.MainConfigOfLifeCycle;
import com.workit.config.MainConfigOfPropertyValues;

public class IOCTest_PropertyValue {
	
	AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
	@Test
	public void test01(){
		printBean(annotationConfigApplicationContext);
		System.out.println("===================");
		Person person = (Person) annotationConfigApplicationContext.getBean("person");
		System.out.println(person);
		ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
		String property = environment.getProperty("person.nickName");
		System.out.println(property);
		//关闭容器
		annotationConfigApplicationContext.close();
	}
	private void printBean(AnnotationConfigApplicationContext applicationContext){
		//打印所有组件名
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
	}
}
