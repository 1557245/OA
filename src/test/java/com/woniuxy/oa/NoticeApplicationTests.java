package com.woniuxy.oa;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniuxy.oa.Mapper.NoticeMapper;
import com.woniuxy.oa.entity.Emps;
import com.woniuxy.oa.handler.NoticePublishController;
import com.woniuxy.oa.service.NoticePublishService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeApplicationTests {
	@Autowired
	NoticeMapper noticeMapper;
	@Autowired
	NoticePublishService noticePublishService;
	@Autowired
	NoticePublishController noticePublishController;

	@Test
	public void contextLoads() {
//		/* System.out.println(noticeMapper.selectNoticeBynid(1)); */
		Date date = new Date();
		SimpleDateFormat publishtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = publishtime.format(date);
		System.out.println(format);
	}

//	@Test
//	public void testgetAllEmps() {
//		noticePublishController.getAllEmps();
//	}

//	@Test
//	public void testpublishNotice() {
//		noticePublishService.publishNotice(1, "攻打东京", "奴役日本天皇", "赵圣杰", "两挂一万想火炮");
//	}
//
//	@Test
//	public void testnoticeAdd() {
//		noticePublishController.noticeAdd("买菜", "卖猪肉", "赵圣杰", "塑料袋");
//	}
//
//	@Test
//	public void testselectEmpsByAcceptName() {
//		List<Emps> selectEmpsByAcceptName = noticeMapper.selectEmpsByAcceptName();
//		String enameList = "";
//		for (Emps emps : selectEmpsByAcceptName) {
//			String ename = emps.getEname();
//			System.out.println(ename);
//			enameList += ename + ",";
//		}
//		System.out.println(enameList);
//		// 前端接收到的接收人名单
//		String Anncepts = "东赵,王五,赵六,赵圣杰";
//		String[] AnnceptArray = Anncepts.split(",");
//		// 添加不存在的接收人名单
//		List<String> NoAccepts = new ArrayList<>();
//		//进行判断
//		for (int i = 0; i < AnnceptArray.length; i++) {
//			boolean contains = enameList.contains(AnnceptArray[i]);
//			if (contains == false) {
//				NoAccepts.add(AnnceptArray[i]);
//			}
//		}
//		String str="";
//		for (String NoAccept : NoAccepts) {
//			str +=NoAccept+",";
//			
//		}
//		System.out.println("不存在的接收人："+str);
//	}
//	@Test
//	public void testcheckAnncept() {
//		String checkAnncept = noticePublishService.checkAnncept("罗东，王五");
//		System.out.println(checkAnncept);
//	}
}
