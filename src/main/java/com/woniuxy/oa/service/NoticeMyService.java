package com.woniuxy.oa.service;

import java.util.List;

import com.woniuxy.oa.entity.Notice;

public interface NoticeMyService {
	// 获取我发布的公告(带了分页条件的)
	List<Notice> getMyPublishNotice(Integer eid, Integer selectStart, Integer pageSize);
	// 获取总页数
	Integer getTotalPage(Integer eid,Integer pageSize);
	// 获取修改的公告的信息进行回显
	public Notice updateMyNotice(Integer nid);
	// 修改我的待审批的公告
	public void updateNotice(Integer nid, String title, String content, String recipinets);
	// 查询接收公告
	public List<Notice>  getMyReceivedNotice(String name, Integer selectStart1, Integer pageSize1);
	Integer getReceivedTotalPage(String name, Integer pageSize);
	
	
}
