package com.woniuxy.oa.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class NotcieConfig implements WebMvcConfigurer{
	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	public DataSource druid() {
		return new DruidDataSource();

	}
	@Override
	public void addViewControllers(ViewControllerRegistry registrty) {
		registrty.addViewController("/").setViewName("index");
		registrty.addViewController("/uploadStatus").setViewName("noticeExceptionMsg");
	}
	
}
