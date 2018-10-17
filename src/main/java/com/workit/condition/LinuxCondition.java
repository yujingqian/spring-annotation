package com.workit.condition;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断是都是linux系统
public class LinuxCondition implements Condition{
		
	/**
	 * ConditionContext，判断条件能使用的上下文（环境）
	 * AnnotatedTypeMetadata ，注释信息
	 * 
	 * */
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata mataData) {
		// TODO Auto-generated method stub
		//判断是否是linux系统
		//1.能获取到ioc使用的beanfactory bean工厂
		ConfigurableBeanFactory beanFactory = context.getBeanFactory();
		//2.获取到类加载器
		ClassLoader classLoader = context.getClassLoader();
		//3.获取到当前的环境信息
		Environment environment = context.getEnvironment();
		//4.获取到bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		String property = environment.getProperty("os.name");
		//可以判断容器中的bean的注册情况，也可以给容器中注册bean
		boolean containsBeanDefinition = registry.containsBeanDefinition("person");
		if(property.contains("linux")){
			return true;
		}
		
		return false;
	}

}
