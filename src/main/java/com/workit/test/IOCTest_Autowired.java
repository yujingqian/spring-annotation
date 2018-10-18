package com.workit.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.workit.bean.Boss;
import com.workit.bean.Car;
import com.workit.bean.Color;
import com.workit.config.MainConfigOfAutowired;
import com.workit.config.MainConfigOfLifeCycle;
import com.workit.dao.BookDao;
import com.workit.service.BookService;

public class IOCTest_Autowired {
	@Test
	public void test01(){
		//第一步，创建ioc容器
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
		BookService bookService = annotationConfigApplicationContext.getBean(BookService.class);
		System.out.println(bookService);
		
		//BookDao bookDao= annotationConfigApplicationContext.getBean(BookDao.class);		
		//System.out.println(bookDao);
		
		Boss boss = annotationConfigApplicationContext.getBean(Boss.class);
		System.out.println(boss);
		
		Car car = annotationConfigApplicationContext.getBean(Car.class);
		System.out.println(car);
		
		Color color = annotationConfigApplicationContext.getBean(Color.class);
		System.out.println(color);
		System.out.println(annotationConfigApplicationContext);
		annotationConfigApplicationContext.close();
	}
}
