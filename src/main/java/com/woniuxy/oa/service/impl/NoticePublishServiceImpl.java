package com.woniuxy.oa.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oa.Mapper.NoticeMapper;
import com.woniuxy.oa.entity.Emps;
import com.woniuxy.oa.service.NoticePublishService;

@Service
public class NoticePublishServiceImpl implements NoticePublishService {

	@Autowired
	NoticeMapper noticeMapper;

	// 发布新公告
	public void publishNotice(Integer n_eid, String title, String content, String recipinets, String annex) {
		Integer nstate = 1;
		Integer nflag = 0;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String publishtime = simpleDateFormat.format(new Date());
		noticeMapper.insertNotice(n_eid, title, content, recipinets, publishtime, annex, nstate, nflag);
	}
	

	// 获取接收人
	public List<Emps> empslist() {
		List<Emps> allEmps = noticeMapper.selectAllEmps();
		return allEmps;
	}

}
