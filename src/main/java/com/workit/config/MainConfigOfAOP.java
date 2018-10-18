package com.workit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.workit.AOP.LogAspects;
import com.workit.AOP.MathCalculator;
/**
 * AOP:【动态代理】
 * 		指在程序运行期间动态的将其代码切入到指定方法指定位置进行运行的编程方式；
 * 
 * 1.导入AOP模块：Spring AOP(spring-aspects)
 * 2.定义一个业务逻辑类（MathCalculator），在业务逻辑运行的时候将日志进行打印（方法之前，方法进行结束，方法未知异常等）
 * 3.定义一个日志切面类（LogAspects）,切面类的方法需要动态感知MathCalculator.div运行到哪里
 * 			通知方法：
 * 				前置通知（@Before）：logStart，在目标方法（div）运行之前运行
 * 				后置通知（@After）：logEnd，在目标方法（div）运行之后运行,无论方法是正常结束还是异常结束
 * 				返回通知（@AfterReturning）：logReturn，在目标方法（div）正常返回运行
 * 				异常通知（@AfterThrowing）：logException，在目标方法（div）运行出现异常运行
 * 				环绕通知（@Around）：动态代理，手动推进目标方法运行（joinPoint.procced()）相当于最底层的通知
 * 4.给切面类的目标方法标注何时何地运行（通知注解）
 * 5(重要).将切面类和业务逻辑类（目标方法所在类）都加入到容器中
 * 6(重要).必须告诉Spring哪个是切面类（给切面类上加一个注解，@Aspect）
 * 7(重要).给配置类加@EnableAspectJAutoProxy，开启基于注解的AOP模式
 * 		在Spring中有很多的@Enablexxx；都是开启某样功能的作用
 * 
 * 三步：
 * 	1、将业务逻辑组件和切面类都加入到容器中，告诉Spring哪个是切面类（@Aspect）
 *  2.在切面类的每一个通知方法标注通知注解，告诉Spring何时何地（切入点表达式）
 *  3.开启基于注解的AOP模式，@EnableAspectJAutoProxy
 *  
 *  
 *  AOP原理：【给容器中注册了什么组件，这个组件什么时候工作，包括这个时候工作的内容是什么】
 *  	@EnableAspectJAutoProxy
 *  1.@EnableAspectJAutoProxy是什么？
 *  	调用了@Import(AspectJAutoProxyRegistrar.class),给容器中导入AspectJAutoProxyRegistrar
 *  		利用AspectJAutoProxyRegistrar自定义给容器注册Bean
 *  		internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator
 *  	给容器中注册一个自动代理的创建器（AnnotationAwareAspectJAutoProxyCreator）
 *  
 *  2.AnnotationAwareAspectJAutoProxyCreator：
 *  	父类：AnnotationAwareAdvisorAutoProxyCreator
 *  		父类：AbstractAdvisorAutoProxyCreator
 *  			父类：AbstractAutoProxyCreator
 *  				父类：SmartInstantiationAwareBeanPostProcessor，BeanFactoryAware
 *  				关注后置处理器（在bean初始化完成前后做的事情），自动装配BeanFactory
 *  
 *  	AbstractAutoProxyCreator.setBeanFactory();
 *      AbstractAutoProxyCreator,有后置处理器的逻辑
 *      
 *      AbstractAdvisorAutoProxyCreator.setBeanFactory()(重写了这个方法)----》initBeanFactory
 *      
 *      AnnotationAwareAspectJAutoProxyCreator.initBeanFactory
 *      
 *      流程：
 *      	1.传入配置类，创建一个ioc容器
 *      	2.注册配置类，调用refresh()刷新容器
 *      	3.注册bean的后置处理器，方便拦截bean的创建
 *      		1：先获取ioc容器已经定义的需要创建对象的所有BeanPostProcessor
 *              2:给容器中加别的BeanPostProcessor
 *              3：优先注册实现了PriorityOrdered接口的BeanPostProcessor
 *              4:再给容器中注册实现了Ordered接口的BeanPostProcessor
 *              5.注册没实现的优先级接口的BeanPostProcessor
 *              6.注册BeanPostProcessor，实际上创建BeanPostProcessor对象，保存在容器中
 *              	创建：internalAutoProxyCreator的BeanPostProcessor【类型是AnnotationAwareAspectJAutoProxyCreator】
 *    					1.创建bean的实例
 *    					2.populateBean:给bean的各种属性赋值
 *    					3.initializeBean：初始化Bean
 *      					1.处理Aware方法的回调
 *      					2.应用后置处理器的BeforeInitialization()
 *      					3.执行自定义的初始化方法
 *      					4.执行后置处理器
 *      				4.BeanPostProcessor(AnnotationAwareAspectJAutoProxyCreator)创建成功
 *      		7.把BeanPostProcessor注册到BeanFactory中：
 *      			BeanFactory.addBeanPostProcessor(postProcessor)
 *  
 * */

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {
	//将业务逻辑类加入容器中
	@Bean
	public MathCalculator mathCalculator(){
		
		return new MathCalculator();
	}
	//将切面类也加入到容器中
	@Bean
	public LogAspects logaspects(){
		
		return new LogAspects();
	}
}
