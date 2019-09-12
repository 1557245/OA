package com.woniuxy.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oa.Mapper.NoticeMapper;
import com.woniuxy.oa.entity.Notice;
import com.woniuxy.oa.service.NoticeExamService;

@Service
public class NoticeExamServiceImpl implements NoticeExamService {
	@Autowired
	NoticeMapper noticeMapper;

	// 查询所有待审批的公告
	@Override
	public List<Notice> getAllWaitedNotice(Integer selectStart2, Integer pageSize2) {
		List<Notice> allWaitedNotice = noticeMapper.selectAllWaitedNotice(selectStart2, pageSize2);
		for (Notice notice : allWaitedNotice) {
			notice.setPublisher(noticeMapper.selectPublisher(notice.getN_eid()).getEname());
		}

		return allWaitedNotice;
	}

	// 查询所有待审批的公告的总条数，并计算总页数
	@Override
	public Integer getAllWaitedNoticeCount(Integer pageSize2) {
		Integer alllWaitedNoticeCount = noticeMapper.selectAllWaitedNoticeCount();
		Integer totalPage2=(alllWaitedNoticeCount%pageSize2==0?alllWaitedNoticeCount/pageSize2:alllWaitedNoticeCount/pageSize2+1);
		return totalPage2;
	}
	// 同意

	public void agree(Integer nid) {
		noticeMapper.agree(nid);
	}

	// 拒绝
	public void refuse(Integer nid) {
		noticeMapper.refuse(nid);
	}
}
