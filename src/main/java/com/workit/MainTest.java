package com.workit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.workit.bean.Person;
import com.workit.config.MainConfig;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext=	new AnnotationConfigApplicationContext(MainConfig.class);
		Person person  = applicationContext.getBean(Person.class);
		System.out.println(person);
		
		String[] nameForType= applicationContext.getBeanNamesForType(Person.class);
		for (String name  : nameForType) {
			System.out.println(name);
		}
	}
}
