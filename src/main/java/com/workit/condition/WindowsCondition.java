package com.workit.condition;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断是否是Windows系统
public class WindowsCondition implements Condition{

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metaData) {
		// TODO Auto-generated method stub
		
		//判断是否是Windows系统
		Environment environment = context.getEnvironment();
		String property = environment.getProperty("os.name");
			if(property.contains("Windows")){
					return true;
			}
				
		return false;
	}

}
