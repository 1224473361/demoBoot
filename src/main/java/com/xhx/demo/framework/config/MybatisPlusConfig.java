package com.xhx.demo.framework.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

/**
 * 
 * @date 2019年6月12日
 * @author lihui
 */
@Configuration
public class MybatisPlusConfig {

	/**
	 * mybatis-plus 分页插件
	 * 
	 * @return
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor p = new PaginationInterceptor();
		p.setDialectType("mysql");
		return p;
	}

	/**
	 * @return
	 */
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.xhx.demo.db.mapper");
		return mapperScannerConfigurer;
	}

}