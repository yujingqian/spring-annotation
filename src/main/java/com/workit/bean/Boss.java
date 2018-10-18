package com.workit.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//默认加载在IOC容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值等操作
@Component
public class Boss {
	private Car car;

	//构造器要用的组件，都是从容器中获取
	@Autowired
	public Boss(/*@Autowired*/ Car car){
		this.car = car;
		System.out.println("Boss...有参构造器。。。。");
	}
	@Override
	public String toString() {
		return "Boss [car=" + car + "]";
	}
	
	public Car getCar() {
		return car;
	}
	@Autowired  //标注在方法上，spring容器在创建当前对象时，就会调用这个方法完成赋值
	//方法使用的参数，自定义类型的值从IOC容器中获取
	public void setCar(Car car) {
		this.car = car;
	}
	
	
	
}
