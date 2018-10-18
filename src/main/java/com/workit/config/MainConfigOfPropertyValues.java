package com.workit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.workit.bean.Person;
//使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中，加载完外部的配置文件以后使用${}取出配置文件中的值
@PropertySource({"classpath:/person.property"})
@Configuration    //这是个配置类
public class MainConfigOfPropertyValues {
	
	@Bean
	public Person person(){
		
		return new Person();
	}
}
