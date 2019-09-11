package com.woniuxy.oa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.service.UserService;
import com.woniuxy.oa.utils.RegexUtil;

@Controller
public class LoginController {
	@Autowired
	UserService userService;

	
	@RequestMapping("/user/login")
	public String login(String account, String password, Model model, HttpServletRequest request) {
		if (account == null || password == null) {
			model.addAttribute("msg", "请输入用户名及密码");
			model.addAttribute("account", account);
			return "login";
		}

		if (!account.matches(RegexUtil.REGEX_MOBILE)) {// 手机号不符
			model.addAttribute("msg", "用户名格式不正确");
			model.addAttribute("account", account);
			return "login";
		}
		if (!password.matches(RegexUtil.REGEX_PASSWORD)) {
			model.addAttribute("msg", "密码格式不正确");
			model.addAttribute("account", account);
			return "login";
		}
		//数据库
		User user = userService.getUserByAccount(account);
		String md5Pass = DigestUtils.md5DigestAsHex(password.getBytes());
		if (user.getSaltpassword() == null) {
			model.addAttribute("msg", "用户名不存在");
			model.addAttribute("account", account);
			return "login";
		}
		
		if (!user.getSaltpassword().equals(md5Pass)) {
			model.addAttribute("msg", "密码错误");
			model.addAttribute("account", account);
			return "login";
		}

		// 将用户名及职员id存入session
		HttpSession session = request.getSession();
		session.setAttribute("account", account);
		session.setAttribute("eid", user.getEid());
		return "system/index/index";

	}

	@RequestMapping("/user/register")
	public String register(String account, String password1, String password2, Integer eid, Model model,
			HttpServletRequest request) {

		// 数据有效性判断
		if (account == null || password1 == null || password2 == null) {
			model.addAttribute("msg", "账号或密码无效");
			return "register";
		}

		if (!account.matches(RegexUtil.REGEX_MOBILE)) {// 手机号不符
			model.addAttribute("msg", "账号格式不正确");
			return "register";
		}
		if (!password1.equals(password2)) {
			model.addAttribute("msg", "密码不一致");
			return "register";
		}
		if (!password1.matches(RegexUtil.REGEX_PASSWORD)) {
			model.addAttribute("msg", "密码格式不正确");
			return "register";
		}

		/*
		 * if (obj == null) { return "验证超时，请重试"; } String codeo = (String) obj; if
		 * (!codeo.equalsIgnoreCase(codeo)) { return "验证码错误"; }
		 */

//		result=userSerivace.selectAccount(account);
//		if(result!=null){
//			return "账号已存在";
//		}

		User user = userService.getUserByAccount(account);
		if (user != null) {
			model.addAttribute("msg", "账号已存在，请重试");
			return "register";
		}
		try {
			userService.addUser(account, password1, eid);
			return "system/index/index";
		} catch (Exception e) {
			model.addAttribute("msg", "用户已被注册，请联系管理员处理");
			return "register";
		}
	}

}
