package com.woniuxy.oa.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.woniuxy.oa.entity.Emps;
import com.woniuxy.oa.entity.Notice;
import com.woniuxy.oa.service.NoticeMyService;
import com.woniuxy.oa.service.NoticePublishService;

@Controller
public class NoticeMyController {

	@Autowired
	NoticeMyService noticeMyService;
	// 为了在修改页面也展示接收人复选框引入的
	@Autowired
	NoticePublishService noticePublishService;

	@RequestMapping("/noticeMyPage")
	public String noticeMyPage() {
		System.out.println("noticeMyPage");

		return "noticeMy";
	}

	// 我的公告页面跳转,还要传递总页码给前台
	@RequestMapping("/noticeMyPageItem")
	@ResponseBody
	public Map<String, Object> noticeMyPageItem(@RequestBody Integer pageNum) {
		System.out.println("noticeMyPageItem:");
		Map<String, Object> result = new HashMap<String, Object>();
		Integer pageSize = 8;
		Integer selectStart = (pageNum - 1) * pageSize;
		Integer eid = 2;
		List<Notice> myPublishNotice = noticeMyService.getMyPublishNotice(eid, selectStart, pageSize);
		Integer totalPage = noticeMyService.getTotalPage(eid, pageSize);
		result.put("Notice", myPublishNotice);
		result.put("totalPage", totalPage);
		return result;
	}

	// 公告编号的传递
	Integer nnid = 0;

	// 获取修改页面返回公告的id
	@RequestMapping("/updateNoticePageItem")
	@ResponseBody
	public String updateNoticePageItem(@RequestBody Integer nid) {
		System.out.println("nid" + nid);
		nnid = nid;
		String jsonString = JSON.toJSONString("返回公告id完成");
		return jsonString;
	}

	// 公告修改界面跳转
	@RequestMapping("/noticeDetailPage")
	public String noticeDetailPage(Model model) {
		System.out.println("noticeDetailPage");
		System.out.println("nnid:::" + nnid);
		Notice updatedMyNotice = noticeMyService.updateMyNotice(nnid);
		List<Emps> empslist = noticePublishService.empslist();

		model.addAttribute("updatedMyNotice", updatedMyNotice);
		model.addAttribute("anncept", empslist);

		return "noticeDetail";
	}

	// 修改之后的内容更新
	@RequestMapping("/noticeDetail")
	public String noticeDetail(Integer id, String title, String content,
			@RequestParam("recipinet") String[] recipinet) {
		String recipinets = "";// 接收人
		// 接收人字符串拼接
		for (String recip : recipinet) {
			recipinets += recip + ",";
		}
		noticeMyService.updateNotice(id, title, content, recipinets);
		return "noticeMy";
	}

	// 附件下载
	@RequestMapping("/downloadAnnex")
	public void downloadAnnex() {
		System.out.println("666666");

	}

	// 接收的公告
	@RequestMapping("/myReceivedNotice")
	@ResponseBody
	public Map<String, Object> getReceivedNotice(@RequestBody Integer pageNum1) {
		System.out.println("annex**");
		Map<String, Object> result1 = new HashMap<String, Object>();
		Integer pageSize1 = 8;
		Integer selectStart1 = (pageNum1 - 1) * pageSize1;
		// 接收人从当前的登录人获取
		String idaccept = "2罗东";
		List<Notice> myReceivedNotice = noticeMyService.getMyReceivedNotice(idaccept, selectStart1, pageSize1);
		Integer receivedTotalPage = noticeMyService.getReceivedTotalPage(idaccept, pageSize1);
		System.out.println(receivedTotalPage);
		result1.put("myReceivedNotice", myReceivedNotice);
		result1.put("receivedTotalPage", receivedTotalPage);
		return result1;

	}

}
