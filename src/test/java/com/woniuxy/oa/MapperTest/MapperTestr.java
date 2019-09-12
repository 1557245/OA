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
public class MapperTestr {
	@Autowired
	NoticeMapper noticeMapper;

	@Test
	public void test() {

	}
	@Test
	public void testselectAllWaitedNotice1() {
		System.out.println(noticeMapper.selectAllWaitedNotice(0, 5));
		System.out.println(noticeMapper.selectAllWaitedNoticeCount());
	}
	@Test
	public void testselectMyPublishNotice() {
//		List<Notice> selectMyPublishNotice = noticeMapper.selectMyPublishNotice(1);
//		System.out.println(selectMyPublishNotice);
	}
	@Test
	public void testselectWaitedNotice() {
		Notice selectWaitedNotice = noticeMapper.selectWaitedNotice(62);
		System.out.println(selectWaitedNotice);
		
	}
	@Test
	public void testselectReceivedNptice() {
//		List<Notice> selectReceivedNptice = noticeMapper.selectReceivedNotice("罗东");
//		System.out.println(selectReceivedNptice);
	}
	
	@Test
	public void testselectAllWaitedNotice() {
//		List<Notice> selectAllWaitedNotice = noticeMapper.selectAllWaitedNotice();
//		System.out.println(selectAllWaitedNotice);
	}
	
	@Test
	public void testAgree() {
		noticeMapper.agree(64);
	}
	@Test
	public void testupdateNotice() {
		noticeMapper.updateNotice(66, "一", "er", "赵圣杰,罗东", "2018-09-07 21:57:36");
	}
}
