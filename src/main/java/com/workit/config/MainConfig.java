package com.workit.config;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.workit.bean.Person;
import com.workit.service.BookService;

//配置类，等于之前的配置文件
@Configuration //告诉Spring这是一个配置类
//@ComponentScan(value="指定要扫描的包")  jdk8,可重复使用多个ComponentScan注解，如果不是jdk8，则可以用@ComponentScans
//excludeFilters=Filter[]  等于Filter数组  指定扫描的时候按照什么规则排除什么组件
//includeFilters=Filter[]  指定扫描的时候按照什么规则包含哪些组件
/*@ComponentScan(value="com.workit",excludeFilters ={
		@Filter(type=FilterType.ANNOTATION,classes={Controller.class})
})*/
/*@ComponentScan(value="com.workit",includeFilters ={
		@Filter(type=FilterType.ANNOTATION,classes={Controller.class})
},useDefaultFilters = false)*/
//FilterType.ASSIGNABLE_TYPE   按照注解
//FilterType.ASSIGNABLE_TYPE   按照给定的类型（例如下面的，service类型下的所以包都会被扫描）
//FilterType.ASPECTj，使用ASPECTj表达式（使用不多）
//FilterType.REGEX，使用正则表达式指定
//FilterType.CUSTOM，使用自定义规则
@ComponentScans(value={@ComponentScan(value="com.workit",includeFilters =
{/*@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
 @Filter(type=FilterType.ASSIGNABLE_TYPE,classes = {BookService.class})	,*/
 @Filter(type=FilterType.CUSTOM,classes = {MyTypeFilter.class})
		},useDefaultFilters = false)})

public class MainConfig {
	@Bean("Person") //给容器中注册一个bean；类型为返回值的类型，id默认为方法名作为Id
	public Person person01(){
		return new Person("lisi", 18);
		
	}
}
