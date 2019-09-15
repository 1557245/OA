package com.woniuxy.oa.ControllerTest;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniuxy.oa.controller.NoticeExamController;
import com.woniuxy.oa.controller.NoticeMyController;
import com.woniuxy.oa.controller.NoticePublishController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeApplicationTests {

	@Autowired
	NoticePublishController noticePublishController;
	@Autowired
	NoticeMyController noticeMyController;
	@Autowired
	NoticeExamController noticeExamController;
	@Test
	public void contextLoads() {

	}

	@Test
	public void testgetReceivedNotice() {
		Map<String, Object> receivedNotice = noticeMyController.getReceivedNotice(1);
		System.out.println(receivedNotice);
	}

	@Test
	public void test() {

	}
	
	
}
