package com.woniuxy.oa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.woniuxy.oa.handlerinterceptor.LoginHandlerInterceptor;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer{
	
	//自定义路径的视图解析
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("login");
//		registry.addViewController("/index.html").setViewName("login");
	}
	
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		WebMvcConfigurer mvcConfigurer = new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/index.html").setViewName("login");
				registry.addViewController("/main").setViewName("index");
			}
			
			//放行部分请求
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(new LoginHandlerInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/","/index.html","/user/login","/css/**","/bootstrap/**","/img/**","/js/**");
			}
		};
		return mvcConfigurer;
	}
	
}
