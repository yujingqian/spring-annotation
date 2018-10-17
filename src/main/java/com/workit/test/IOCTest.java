package com.workit.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.workit.bean.Blue;
import com.workit.bean.Person;
import com.workit.config.MainConfig;
import com.workit.config.MainConfig2;

public class IOCTest {
	AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext(MainConfig2.class);
	
	//测试Import导入的方法
	@Test
	public void testImport(){
		printBean(applicationContext);
		Blue bean = applicationContext.getBean(Blue.class);
		System.out.println(bean);
		//工厂bean获取的是调用getObject创建的对象
		Object bean2 = applicationContext.getBean("colorFactoryBean");
		Object bean3 = applicationContext.getBean("colorFactoryBean");
		System.out.println("Beande的类型："+bean2.getClass());
		System.out.println(bean2 == bean3);
		//加前缀&，则拿的是工厂Bean的本身，不然则拿到的是colorFactoryBean里面getObject里创建的ColorBean
		Object bean4 = applicationContext.getBean("&colorFactoryBean");
		System.out.println(bean4.getClass());
	}
	
	private void printBean(AnnotationConfigApplicationContext applicationContext){
		//打印所有组件名
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
	}
	
	
	@SuppressWarnings("resource")
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext(MainConfig.class);
		String[] beanDefinitionNames=applicationContext.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
		
	}
	
	
	@Test
	public void test02(){
		AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext(MainConfig2.class);
		/*String[] beanDefinitionNames=applicationContext.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
		
		Object bean = applicationContext.getBean("person");
		Object bean2 = applicationContext.getBean("person");
		
		System.out.println(bean == bean2);*/
		System.out.println("ioc容器创建完成。。。。");
		Object bean = applicationContext.getBean("person");
		Object bean2 = applicationContext.getBean("person");
		System.out.println(bean == bean2);
	}
	
	@Test
	public void test03(){
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
		//动态获取环境变量的值
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		//获取操作系统的名字  
		String property = environment.getProperty("os.name");
		System.out.println(property);
		for (String name : beanNamesForType) {
			System.out.println(name);
		}
		
		Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
		System.out.println(persons);
	}
}
