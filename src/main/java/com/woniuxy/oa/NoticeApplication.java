package com.woniuxy.oa;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.woniuxy.oa.Mapper")
@SpringBootApplication
public class NoticeApplication {
	// 设置时区 相差8小时
	@PostConstruct 
	void setDefaultTimezone() {
	    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai")); 
	} 

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
		SpringApplication.run(NoticeApplication.class, args);
	}

}
