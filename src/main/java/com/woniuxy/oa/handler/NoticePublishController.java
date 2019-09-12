package com.woniuxy.oa.handler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.woniuxy.oa.entity.Emps;
import com.woniuxy.oa.service.NoticePublishService;

/**
 * 
 * @author LuoDong
 *
 */
@Controller
public class NoticePublishController {
	@Autowired
	NoticePublishService noticePublishService;

	// 跳转发布公告页面,同时查出所有的联系人，放在接收人列表上面
	@RequestMapping("/noticeAddPage")
	public String noticeAddPage(Model model) {
		List<Emps> empslist = noticePublishService.empslist();
		model.addAttribute("anncept", empslist);
		return "noticeAdd";
	}

	// 发布新公告,待发布的公告编辑完成之后，页面转向我的公告页面noticeMy
	@RequestMapping("/noticeAdd")
	public ModelAndView noticeAdd(@RequestParam("annex") MultipartFile annex, String title, String content,
			@RequestParam("recipinet") String[] recipinet) throws IOException {
		ModelAndView mv = new ModelAndView();
		String annexroute = null;// 附件的文件路径
		String recipinets = "";// 接收人
		Integer n_eid = 1;// 发件人
		try {
			if (annex.isEmpty()) {
				// 没有附件的情况
				annexroute = "无附件";
			} else {
				// 有附件的时候  得出附件的文件路径
				byte[] bytes = null;
				bytes = annex.getBytes();
				Path path = Paths.get("E:\\fileUpload/" + annex.getOriginalFilename());
				annexroute = path.toString();
				Files.write(path, bytes);
			}
			// 接收人字符串拼接
			for (String recip : recipinet) {
				recipinets += recip + ",";
			}
			// 公告正式插入
			noticePublishService.publishNotice(n_eid, title, content, recipinets, annexroute);
			mv.setViewName("noticeMy");
		} catch (Exception e) {
			mv.addObject("publisdException", "公告发布失败");
			mv.setViewName("noticeExceptionMsg");
			e.printStackTrace();
		}
		return mv;
	}
}
