package com.workit.bean;

import org.springframework.beans.factory.FactoryBean;
//创建一个Spring定义的工厂bean
public class ColorFactoryBean implements FactoryBean<Color>{
	//返回一个color对象，这个对象会添加到容器中
	public Color getObject() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ColorFactoryBean.....");
		return new Color();
	}

	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Color.class;
	}
	//控制这个Bean是否是单实例，
	//true：这个实例是单实例，在容器中保存一份
	//false：这个是多实例，每次获取都会创建一个新的Bean
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
