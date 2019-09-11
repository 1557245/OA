package com.woniuxy.oa;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OaApplication {
	
	@PostConstruct
	void setDefaultTimezone() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
	}
	
	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
		SpringApplication.run(OaApplication.class, args);
	}

}
