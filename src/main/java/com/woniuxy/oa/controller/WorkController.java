package com.woniuxy.oa.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniuxy.oa.entity.Work;
import com.woniuxy.oa.entity.WorkPart;
import com.woniuxy.oa.service.WorkService;

@Controller
public class WorkController {
	@Autowired
	WorkService workService;

	// 全部显示
	@RequestMapping("/work/showall")
	public String showall(Model model) {
		System.out.println("/work/showall");
		List<Work> works = workService.getAllWork();
		model.addAttribute("works", works);
		return "work/work";

	}

	// 分页显示
//	@RequestMapping("/work/showpart")
//	public String showpart(Work work, Integer curent, Model model, HttpServletRequest request,
//			HttpServletResponse response) {
//		System.out.println("/work/showpart");
//		try {
//			WorkPart<Work> wp = new WorkPart<Work>();
//			int num = 5;
//			if (curent == null) {
//				curent = 1;
//			}
//			if(work.getName()==null && work.getPlan()==null&&work.getProblem()==null
//					&&work.getSummary()==null&&work.getWid()==0&&work.getEid()==0) {//获取session里的条件word
//				Work swork=(Work) request.getSession().getAttribute("word");
//				if(swork==null) {
//					System.out.println(swork);
//				}else {
//					work=swork;
//					System.out.println("获取session条件："+work);
//				}
//				
//			}else {//将条件存入session
//				System.out.println("将条件存入session");
//				request.getSession().setAttribute("word", work);
//			}
//			System.out.println(work);
//			wp = workService.showPartByWork(num, curent, work);
//			String url = getUrl(request, response);
//			System.out.println("条件："+work);
//			System.out.println("url:::" + url);
//			wp.setUrl(url);
//			model.addAttribute("works", wp);
//			System.out.println(wp);
//			return "work/work";
//		} catch (Exception e) {
//			model.addAttribute("msg", e.getMessage());
//			return "work/work";
//		}
//	}

	// 分页显示2试试
	@RequestMapping("/work/showpart")
	public String showpart(Work work, Integer year, Integer month, Integer curent, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("/work/showpart"); 
		try {
			WorkPart<Work> wp = new WorkPart<Work>();
			int num = 5;
			if (curent == null) {
				curent = 1;
			}
			
			if(year==null) {
				Integer syear = (Integer) request.getSession().getAttribute("year");
				if(syear!=null) {
					year=syear;
//					model.addAttribute("year", year);
				}else {
					System.out.println("syear==null");
				}
			}else {
				request.getSession().setAttribute("year", year);
//				model.addAttribute("year", year);
			}
			if(month==null) {
				Integer smonth = (Integer) request.getSession().getAttribute("month");
				if(smonth!=null) {
					month=smonth;
				}else {
					System.out.println("smonth==null");
				}
			}else {
				request.getSession().setAttribute("month", month);
			}
			
			if (work.getName() == null && work.getPlan() == null && work.getProblem() == null
					&& work.getSummary() == null && work.getWid() == 0 && work.getEid() == 0) {// 获取session里的条件word
				Work swork = (Work) request.getSession().getAttribute("word");
				if (swork == null) {
					System.out.println(swork);
				} else {
					work = swork;
					System.out.println("获取session条件：" + work);
				}
			} else {// 将条件存入session
				System.out.println("将条件存入session");
				request.getSession().setAttribute("word", work);
			}
			System.out.println(work);
			wp = workService.showPartByWork1(num, curent, work,year,month);
			String url = getUrl(request, response);
			System.out.println("条件：" + work);
			System.out.println("url:::" + url);
			wp.setUrl(url);
			model.addAttribute("works", wp);
			System.out.println(wp);
			return "work/work";
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "work/work";
		}
	}

	/*
	 * @RequestMapping("/work/lastpage") public String lastpage(Work work, Model
	 * model, HttpServletRequest request, HttpServletResponse response) {
	 * System.out.println("/work/lastpage/{curent}"); Integer curent =
	 * Integer.parseInt(request.getParameter("curent")); String rr = showpart(work,
	 * curent, model, request, response); System.out.println(rr); return rr; }
	 */

	/*
	 * @RequestMapping("/work/nextpage") public String nextpage(Work work, Model
	 * model, HttpServletRequest request, HttpServletResponse response) {
	 * System.out.println("/work/nextpage/{curent}"); Integer curent =
	 * Integer.parseInt(request.getParameter("curent")); String rr = showpart(work,
	 * curent, model, request, response); System.out.println(rr); return rr; }
	 */

	// 翻页
	/*
	 * @RequestMapping("/work/showparttojs") public WorkPart<Work> showparttojs(Work
	 * work, Integer curent, Model model, String url) { System.out.println(333333);
	 * System.out.println("/work/showparttojs"); try { WorkPart<Work> wp = new
	 * WorkPart<Work>(); int num = 5; if (curent == null) { curent = 1; } wp =
	 * workService.showPartByWork(num, curent, work); wp.setUrl(url); return wp; }
	 * catch (Exception e) { model.addAttribute("msg", e.getMessage()); return null;
	 * } }
	 */

	/**
	 * 获取条件url
	 * 
	 * @param request
	 * @param response
	 * @return 条件，url
	 */
	private static String getUrl(HttpServletRequest request, HttpServletResponse response) {
		StringBuilder url = new StringBuilder();
		url.append(request.getContextPath());
		url.append(request.getServletPath() + "?");
		String u = request.getQueryString();
		if (u != null && u.indexOf("&curent") != -1) {
			u = u.substring(0, u.indexOf("&curent"));
		}
		url.append(u);
		return url.toString();
	}

	@RequestMapping("/work/getworkbyname")
	public String getworkbyname(String name, Model model) {
		System.out.println("/work/getworkbyname");
		Work work = workService.getWorkByName(name);
		model.addAttribute("works", work);
		System.out.println("work:" + work);
		return "work/work";

	}

	// 查询的数据传到update页面
	@RequestMapping("/work/select")
	public String selectById(Integer wid, Model model) {
		System.out.println("/work/select");
		System.out.println("select  id:" + wid);
		Work work = workService.selectWorkById(wid);
		System.out.println("work:" + work);
		model.addAttribute("work", work);
		return "work/update";
	}

	// update页面传来的数据，判断有效后修改
	@RequestMapping("/work/update")
	public String updateById(Work work, Model model) {
		System.out.println("/work/update");
		if (work.getName() == "" || work.getName() == null) {
			model.addAttribute("msg", "姓名不允许为空！");
			model.addAttribute("work", work);
			return "work/update";
		}
		if (work.getSummary() == "" || work.getSummary() == null) {
			model.addAttribute("msg", "本周总结不允许为空！");
			model.addAttribute("work", work);
			return "work/update";
		}
		if (work.getProblem() == "" || work.getProblem() == null) {
			model.addAttribute("msg", "本周问题不允许为空！");
			model.addAttribute("work", work);
			return "work/update";
		}
		if (work.getPlan() == "" || work.getPlan() == null) {
			model.addAttribute("msg", "下周计划不允许为空");
			model.addAttribute("work", work);
			return "work/update";
		}
		Date date = new Date();
		work.setCreatedate(date);
		workService.updateWork(work);
		System.out.println("work:" + work);
		return "redirect:/work/showpart";
	}

	// 点击删除后删除
	@RequestMapping("/work/delete")
	public String deleteById(Integer wid) {
		workService.deleteWorkById(wid);
		return "redirect:/work/showpart";
	}

	// 插入页面传来的数据插入数据库
	@RequestMapping("/work/insert")
	public String insertWork(Work work, Model model) {
		System.out.println("/work/insert");
		if (work.getName() == null || work.getName().equals("")) {
			model.addAttribute("work", work);
			model.addAttribute("msg", "姓名不能为空");
			return "work/insert";
		}
		if (work.getSummary() == null || work.getSummary().equals("")) {
			model.addAttribute("work", work);
			model.addAttribute("msg", "本周总结不能为空");
			return "work/insert";
		}
		if (work.getProblem() == null || work.getProblem().equals("")) {
			model.addAttribute("work", work);
			model.addAttribute("msg", "本周问题不能为空");
			return "work/insert";
		}
		if (work.getPlan() == null || work.getPlan().equals("")) {
			model.addAttribute("work", work);
			model.addAttribute("msg", "下周计划不能为空");
			return "work/insert";
		}

		try {
			Date date = new Date();
			work.setCreatedate(date);
			workService.insertWork(work);
			return "redirect:/work/showpart";
		} catch (Exception e) {
			model.addAttribute("msg", "添加失败");
			return "work/insert";
		}
	}

}
