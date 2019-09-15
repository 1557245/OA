package com.woniuxy.oa.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String noticeExaminPage(Model model) {
		try {
			return "noticeExamin";
		} catch (Exception e) {
			model.addAttribute("publisdException", "去公告审批途中发生了意外");
			return "noticeExceptionMsg";
		}

	}

	// 查询所有待审批的公告
	@RequestMapping("/allWaitNotice")
	@ResponseBody
	public Map<String, Object> getAllWaitNotice(@RequestBody Integer pageNum3) {
		System.out.println("getAllWaitNotice");
		Integer pageSize3 = 8;
		Integer selectStart2 = (pageNum3 - 1) * pageSize3;
		List<Notice> allWaitedNotice = noticeExamService.getAllWaitedNotice(selectStart2, pageSize3);
		Integer totalPage3 = noticeExamService.getAllWaitedNoticeCount(pageSize3);
		Map<String, Object> result2 = new HashMap<String, Object>();
		result2.put("allWaitedNotice", allWaitedNotice);
		result2.put("totalPage3", totalPage3);
		System.out.println("totalPage3:" + totalPage3);
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

	// 文件下载参数的传递
	Integer nidPara = 0;
	Integer n_asid = 0;

	@RequestMapping("/downloadFilePara")
	@ResponseBody
	public String downloadFilePara(@RequestBody Integer noticeId) {
		nidPara = noticeId;
		String jsonString = JSON.toJSONString("文件下载功能前后交互成功");
		return jsonString;
	}

	// 文件下载页面跳转
	String fileRote = "";

	@RequestMapping("/toDownloadFile")
	public String toDownloadFile(Model model) {
		Notice notice = noticeExamService.getFile(nidPara);
		fileRote = notice.getAnnex();
		String fileName=fileRote.substring(15);
		System.out.println("fileName"+fileName);
		n_asid = notice.getN_asid();
		model.addAttribute("fileMsg", fileName);
		return "noticeFileDownload";
	}

	// 实现文件下载然后跳转回我的公告页面
	@RequestMapping("/downloadFile")
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
		String fileName = fileRote.substring(fileRote.lastIndexOf("\"") + 1);
		System.out.println("fileNamefileName"+fileName);
		if (fileRote != null) {
			File file = new File(fileRote);
			if (file.exists()) {
				OutputStream os = null;
				try {
					os = response.getOutputStream();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				response.reset();
				response.setContentType("application/force-download");// 设置强制下载不打开
				response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
				byte[] buffer = new byte[1024];
				System.out.println("buffer:" + buffer);
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);

					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
				} catch (Exception e) {

				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}