package com.workit.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.workit.AOP.MathCalculator;
import com.workit.config.MainConfigOfAOP;

public class IOCTest_AOP {
	@Test
	public void test01(){
		//第一步，创建ioc容器
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		//不要自己创建一个新的对象
		/*MathCalculator mathCalculator = new MathCalculator();
		mathCalculator.div(1, 1);*/
		MathCalculator mathCalculator = annotationConfigApplicationContext.getBean(MathCalculator.class);
		mathCalculator.div(1, 0);
		annotationConfigApplicationContext.close();
	}
}
