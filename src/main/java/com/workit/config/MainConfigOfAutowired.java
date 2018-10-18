package com.workit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.workit.bean.Car;
import com.workit.bean.Color;
import com.workit.dao.BookDao;
/**
 * 自动配置：
 * 		Spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值
 * 		
 * 1）. @Autowired,自动注入
 * 		1.默认优先按照类型去容器中找对应的组件 annotationConfigApplicationContext.getBean(BookDao.class)
 * 			找到就赋值
 * 		2.如果找到了多个相同类型的组件，再将属性的名称作为组件的Id去容器中查找
 * 			annotationConfigApplicationContext.getBean(BookDao.class)
 * 		3.@Qualifier("bookDao").使用@Qualifier指定需要装配的组件的id，而不是使用属性名
 * 		4.自动装配默认一定要将属性赋好值，否则没有就会报错
 * 			可以使用@Autowired(required=false) 表明有的话就会去配置，没有就算了
 * 		5.@Primary，让Spring进行自动装配的时候，默认使用首选的bean	
 * 				也可以继续使用@Qualifier指定需要装配的bean的名字，这时候生效的就是@Qualifier指定的bean
 * 		BookService{
 * 			@Autowired
 * 			BookDao bookDao}
 * 
 * 2）.Spring还支持使用@Resource（JSR250）和@Inject（JSR330）【java规范的注解】
 * 		@Resource：可以和@Autowired一样实现自动装配功能，默认是按照组件名称进行装配的
 * 					没有能支持@Primary和@Autowired(required=false)
 * 		@Inject：需要导入javax.inject的包，和@Autowired的功能一样，没有required=false的功能
 * 	@Autowired：Spring定义的，@Resource、@Inject都是java规范
 * 	AutowiredAnnotationBeanPostProcessor：解析完成自动装备功能
 * 
 * 3）@Autowired：构造器、参数、方法、属性	，都是从容器中获取参数，组件的值
 * 		1.标注在方法位置,@Bean+方法参数，参数从容器中获取，默认不写@Autowired效果是一样的都能自动装配
 *      2.标注在构造器上：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是自动从容器中获取
 *      3.也可以标注在参数位置
 *      
 * 4）自定义组件想要使用Spring容器底层的一些组件（ApplicationContext，BeanFactory，xxx）
 * 自定义	组件实现xxxxAware：在创建对象的时候会调用接口规定的方法注入相关的组件
 *	把spring底层的一些组件注入到自定义的bean中
 *  xxxAware：功能使用xxxprocessor 后置处理器处理：
 *  		ApplicationContextAware-----》ApplicationContextAwareProcessor
 *
 *
 *
 * */

@Configuration
@ComponentScan({"com.workit.controller","com.workit.service",
	"com.workit.dao","com.workit.bean"})
public class MainConfigOfAutowired {
	@Primary
	@Bean("bookDao2")
	public BookDao bookDao(){
		BookDao bookDao = new BookDao();
		bookDao.setLable("2");
		return bookDao;
	}
	/**
	 * @Bean 标注的方法创建对象的时候，方法参数的值从容器中获取
	 * @param car
	 * @return
	 * */
	
	@Bean
	public Color color(Car car){
		Color color = new Color();
		color.setCar(car);
		return color;
	}
	
}