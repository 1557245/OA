package com.woniuxy.oa.MapperTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniuxy.oa.Mapper.NoticeMapper;
import com.woniuxy.oa.entity.Notice;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
	@Autowired
	NoticeMapper noticeMapper;

	@Test
	public void test() {

	}
	// 测试 我的公告
	@Test
	public void testselectMyPublishNotice() {
		List<Notice> selectMyPublishNotice = noticeMapper.selectMyPublishNotice(1, 0, 5);
		System.out.println(selectMyPublishNotice);
	}
	// 查询公告的状态
	@Test
	public void testselectNoticeState() {
		String selectNoticeState = noticeMapper.selectNoticeState(1);
		System.out.println(selectNoticeState);
	}
	// 测试接收人
	@Test
	public void testselectReceivedNotice() {
		List<Notice> selectReceivedNotice = noticeMapper.selectReceivedNotice("罗东", 0, 5);
		System.out.println(selectReceivedNotice);
	}

}
