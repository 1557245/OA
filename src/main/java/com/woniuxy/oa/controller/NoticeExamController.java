package com.woniuxy.oa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.woniuxy.oa.entity.Notice;
import com.woniuxy.oa.service.NoticeExamService;

@Controller
public class NoticeExamController {
	@Autowired
	NoticeExamService noticeExamService;


	@RequestMapping("/noticeExaminPage")
	public String noticeExaminPage() {
		System.out.println("noticeExaminPage:");
		return "noticeExamin";
	}

	// 查询所有待审批的公告
	@RequestMapping("/allWaitNotice")
	@ResponseBody
	public Map<String,Object> getAllWaitNotice(@RequestBody Integer  pageNum3) {
	 	System.out.println("getAllWaitNotice");
		Integer  pageSize3 =8;
		Integer selectStart2=(pageNum3-1)*pageSize3;
		List<Notice> allWaitedNotice = noticeExamService.getAllWaitedNotice(selectStart2,pageSize3);
		Integer totalPage3=noticeExamService.getAllWaitedNoticeCount(pageSize3);
		Map<String,Object> result2=new HashMap<String,Object>();
		result2.put("allWaitedNotice", allWaitedNotice);
		result2.put("totalPage3", totalPage3);
		System.out.println("totalPage3:"+totalPage3);
		return result2;
	}

	// 同意
	@RequestMapping("/agreeNotice")
	@ResponseBody
	public String agree(@RequestBody Integer nid) {
		noticeExamService.agree(nid);
		String jsonString = JSON.toJSONString("同意操作成功");
		return jsonString;
	}

	// 拒绝
	@RequestMapping("/refuseNotice")
	@ResponseBody
	public String refuse(@RequestBody Integer nid) {
		noticeExamService.refuse(nid);
		String jsonString = JSON.toJSONString("驳回操作成功");
		return jsonString;
	}

	// 文件下载
	@RequestMapping("/downloadFile")
	@ResponseBody
	public String downloadFile(@RequestBody String fileRote, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("文件下载功能前后交互成功:" + fileRote);
		String file1 = fileRote.substring(1, 14);
		String fileName = fileRote.substring(14, fileRote.lastIndexOf("\""));
		String file3 = file1 + "\\" + fileName;
		System.out.println(file3);
		String jsonString = JSON.toJSONString("文件下载功能前后交互成功");
		return jsonString;
	}

}