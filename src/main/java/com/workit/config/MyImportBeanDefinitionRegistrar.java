package com.workit.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.workit.bean.RainBow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	/**
	 * AnnotationMetadata:当前类的注解信息
	 * BeanDefinitionRegistry：BeanDefinition注册类
	 * 	把所有需要添加到容器中的bean：调用
	 *  BeanDefinitionRegistrar.registerBeanDefinition手工注册进来
	 * */
	public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
		// TODO Auto-generated method stub
		//看容器中是否有蓝色的，红色的
		boolean containsBeanDefinition = beanDefinitionRegistry.containsBeanDefinition("com.workit.bean.Red");
		boolean containsBeanDefinition2 = beanDefinitionRegistry.containsBeanDefinition("com.workit.bean.Blue");
		if(containsBeanDefinition && containsBeanDefinition2){
			//指定bean定义信息：（Bean的类型，Bean的scope【作用域等等】）
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
			//注册一个bean
			beanDefinitionRegistry.registerBeanDefinition("RainBow", rootBeanDefinition);
		}
	}

}
