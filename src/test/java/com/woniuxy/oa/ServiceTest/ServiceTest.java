package com.woniuxy.oa.ServiceTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniuxy.oa.entity.Notice;
import com.woniuxy.oa.service.NoticeExamService;
import com.woniuxy.oa.service.NoticeMyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
	@Autowired
	NoticeMyService nocticeMyService;
	@Autowired
	NoticeExamService nocticeExamService;
	@Test
	public void test() {

	}
	
	@Test
	public void testgetMyPublishNotice() {
//		List<Notice> myPublishNotice = nocticeMyService.getMyPublishNotice(1);
		
//		System.out.println(myPublishNotice);
	}
	@Test
	public void testgetAllWaitedNotice() {
//		List<Notice> allWaitedNotice = nocticeExamService.getAllWaitedNotice();
//		System.out.println(allWaitedNotice);
	}
	@Test
	public void testagree() {
		nocticeExamService.agree(67);
		
	}
}
