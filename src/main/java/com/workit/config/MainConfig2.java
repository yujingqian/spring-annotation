package com.workit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.workit.bean.Color;
import com.workit.bean.ColorFactoryBean;
import com.workit.bean.Person;
import com.workit.bean.Red;
import com.workit.condition.LinuxCondition;
import com.workit.condition.MyImportSelector;
import com.workit.condition.WindowsCondition;
//放在整个类上表示满足当前条件，这个类中配置的所有的bean注册才能生效（类中组件统一设置）
@Conditional({WindowsCondition.class})  
@Configuration
@Import({Color.class,Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})   
//Import导入组件，id默认为组件的全类名
public class MainConfig2 {
	
	/**
	 * 给容器中注册组件：
	 * 1）包扫描+组件标注注解（@Controller/@Service/@Repository/@component) [但有局限性，只能是自己创建的类]
	 * 2）@Bean[导入的第三方包里面的组件]
	 * 3）@Import[快速的给容器中导入一个组件]
	 * 		①.@Import(要导入到容器的组件),容器中就会自动注册这个组件，id默认为全类名
	 * 		②.ImportSelector,返回需要导入的组件的全类名数组
	 * 		③.ImportBeanDefinitionRegistrar:手动注册Bean到容器中
	 * 4）使用Spring提供的FactoryBean（工厂Bean）
	 * 		①.默认获取到的是工厂bean调用getObject创建的对象
	 * 		②.要获取工厂bean本身，我们需要在id前面加一个&
	 * 			例如：&colorFactoryBean
	 * */
	@Bean
	public ColorFactoryBean colorFactoryBean(){
		return new ColorFactoryBean();
	}
	
	
	/*
	 * @Scope 调整作用域，指定作用范围
	 * prototype，多实例  ioc容器启动并不会去调用方法创建对象放在容器中
	 * 			 每次获取的时候才会调用方法创建对象。
	 * singletype，单实例（默认值）,ioc容器启动会调用方法创建对象放到ioc容器中
	 * 				以后每次获取直接从容器(map.get())中拿
	 * request：同一次请求创建一个实例
	 * session：同一个session创建一个实例
	 * 
	 * 
	 * 懒加载：单实例bean，默认在容器启动的时候创建对象
	 * 懒加载：容器在启动时不创建对象，第一次使用（获取）bean创建对象，并初始化
	 * */
	//@Scope("prototype")
	//默认为单实例，但启动时不创建对象
	@Lazy
	@Bean("person")
	public Person person(){
		System.out.println("给容器中添加person");
		return new Person("zhangsan", 25);
	}
	/**
	 * @Conditional({})---->是个数组,按照一定的条件判断，满足条件给容器中注册bean
	 * 
	 * 如果系统是Windows，给容器注册("Bill")
	 * 如果系统是linux，给容器注册("Linux")
	 * 	 * */
	@Conditional({WindowsCondition.class})
	@Bean("bill")
	public Person person2(){
		
		return new Person("bill",30);
	}
	@Conditional({LinuxCondition.class})
	@Bean("linux")
	public Person person3(){
		
		return new Person("linux",40);
	}
	
	
}
