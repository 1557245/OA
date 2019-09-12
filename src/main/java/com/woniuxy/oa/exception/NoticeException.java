package com.woniuxy.oa.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class NoticeException {
	// 文件默认大小是1M
    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
       // 文件过大时候的提醒
    	redirectAttributes.addFlashAttribute("message", "附件上传失败，附件大小不能超过1M！请返回重试！！");
       // 文件过大的时候跳转的页面
    	return "redirect:/uploadStatus";
    }
}