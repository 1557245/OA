package com.woniuxy.oa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
 
@Component
@ConfigurationProperties(prefix = ConfigProperties.PREFIX)
public class ConfigProperties {
    public static  final String PREFIX = "ws";
  
    private String excelTemplateDpwloadPath;
 
    public String getExcelTemplateDpwloadPath() {
        return excelTemplateDpwloadPath;
    }
 
    public void setExcelTemplateDpwloadPath(String excelTemplateDpwloadPath) {
        this.excelTemplateDpwloadPath = excelTemplateDpwloadPath;
    }

	public ConfigProperties(String excelTemplateDpwloadPath) {
		super();
		this.excelTemplateDpwloadPath = excelTemplateDpwloadPath;
	}

	public ConfigProperties() {
		super();
		// TODO Auto-generated constructor stub
	}
 
}
