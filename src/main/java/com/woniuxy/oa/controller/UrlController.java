package com.woniuxy.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.oa.entity.Work;
import com.woniuxy.oa.entity.WorkPart;

/**
 * 用于页面跳转，href=""，src="",等等
 * @author Administrator
 *
 */
@Controller
public class UrlController {
	
	
	@RequestMapping("/totop")
	public String totop() {
		return "system/index/top";
	}
	
	@RequestMapping("/tomenu")
	public String tomenu() {
		return "system/index/menu";
	}
	@RequestMapping("/tocontent")
	public String tocontent() {
		return "system/index/content";
	}
	
	@RequestMapping("/toinsert")
	public String toinsert(Model model) {
		Work work = new Work();
		model.addAttribute("work", work);
		return "work/insert";
	}
	@RequestMapping("/topassword")
	public String topassword(Model model) {
		return "system/index/password";
	}
	@RequestMapping("/toworkjs")
	public WorkPart<Work> toworkjs(WorkPart<Work> lworks,Model model) {
		return lworks;
	}
	
}
