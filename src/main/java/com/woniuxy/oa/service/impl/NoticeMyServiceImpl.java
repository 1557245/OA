package com.woniuxy.oa.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oa.Mapper.NoticeMapper;
import com.woniuxy.oa.entity.Notice;
import com.woniuxy.oa.service.NoticeMyService;

@Service
public class NoticeMyServiceImpl implements NoticeMyService {
	@Autowired
	NoticeMapper noticeMapper;

	// 我的公告（带分页参数）
	@Override
	public List<Notice> getMyPublishNotice(Integer eid, Integer selectStart, Integer pageSize) {
		List<Notice> myPublishNotice = noticeMapper.selectMyPublishNotice(eid, selectStart, pageSize);
		for (Notice notice : myPublishNotice) {
			Integer n_asid = notice.getN_asid();
			notice.setFontstate(noticeMapper.selectNoticeState(n_asid));	
		}
		return myPublishNotice;
	}

	// 查询我的总页数
	@Override
	public Integer getTotalPage(Integer eid, Integer pageSize) {
		Integer counts = noticeMapper.selectMyPublishNoticeCount(eid);
		Integer totalPage = (counts % pageSize == 0 ? counts / pageSize : counts / pageSize + 1);
		return totalPage;
	};

	// 修改待审批的公告
	public Notice updateMyNotice(Integer nid) {
		Notice waitedUpdateNotice = noticeMapper.selectWaitedNotice(nid);
		return waitedUpdateNotice;
	}

	// 将更新的公告更新到数据库中
	public void updateNotice(Integer nid, String title, String content, String recipinets) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String publishtime = simpleDateFormat.format(new Date());
		noticeMapper.updateNotice(nid, title, content, recipinets, publishtime);
	}

	// 我接收的公告
	public List<Notice> getMyReceivedNotice(String idname, Integer selectStart1, Integer pageSize1) {

		List<Notice> receivedNotice = noticeMapper.selectReceivedNotice(idname, selectStart1, pageSize1);
		for (Notice notice : receivedNotice) {
			// 获取公告状态
			Integer n_asid = notice.getN_asid();
			notice.setFontstate(noticeMapper.selectNoticeState(n_asid));	
			// 添加发布人姓名
			notice.setPublisher(noticeMapper.selectPublisher(notice.getN_eid()).getEname());
		}
		return receivedNotice;
	}

	// 查询接收公告的总页数
	@Override
	public Integer getReceivedTotalPage(String name, Integer pageSize) {
		Integer counts = noticeMapper.selectReceivedNoticeCount(name);
		Integer totalPageReceived = (counts % pageSize == 0 ? counts / pageSize : counts / pageSize + 1);
		return totalPageReceived;
	};
}
