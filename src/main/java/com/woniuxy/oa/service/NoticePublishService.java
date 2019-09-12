package com.woniuxy.oa.service;

import java.nio.file.Path;
import java.util.List;

import com.woniuxy.oa.entity.Emps;


public interface NoticePublishService {
	
	// 发布新公告
	public void publishNotice(Integer n_eid,String title,String content,String recipinets,String annex );
	// 获取接收人
	public List<Emps> empslist();
}
