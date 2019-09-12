package com.woniuxy.oa.service;

import java.util.List;

import com.woniuxy.oa.entity.Notice;

public interface NoticeExamService {
	
	// 查询所有待审批的公告
	List<Notice> getAllWaitedNotice(Integer selectStart2, Integer pageSize2);
	Integer getAllWaitedNoticeCount(Integer pageSize2);
	// 同意
	public void agree(Integer nid);
	// 拒绝
	public void refuse(Integer nid);
	
	
}
