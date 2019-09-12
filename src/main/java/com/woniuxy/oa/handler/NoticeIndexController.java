package com.woniuxy.oa.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeIndexController {
	
	@RequestMapping("/toMenu")
	public String  toMenu() {
		return "menu";
		
	}
	@RequestMapping("/toContent")
	public String  toContent() {
		return "content";
		
	}
	@RequestMapping("/toTop")
	public String  toTop() {
		return "top";
		
	}
}