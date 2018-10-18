package com.workit.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;

/**
 * profile
 *   spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 *   
 *   
 *   开发环境  测试环境  生产环境
 * 		数据源(/A) (/B)(/C)
 * 
 * */
@Configuration
public class MainConfigOfProfile {
	public DataSource dataSource(){
		return null;
	}
}
