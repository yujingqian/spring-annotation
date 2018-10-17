package com.workit.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector{
	//返回值就是要导入到容器中的组件全类名
	//AnnotationMetadata：当前标注@Import注解的类的所有注解信息

	public String[] selectImports(AnnotationMetadata arg0) {
		// TODO Auto-generated method stub
		//importingClassMetadata
		//方法不要返回null，不然会报错
		return new String[]{"com.workit.bean.Blue","com.workit.bean.Yellow"};
	}




	
}
