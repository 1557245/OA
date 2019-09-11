package com.woniuxy.oa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import com.woniuxy.oa.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OaApplicationTests {
	
	@Autowired
	UserMapper userMapper;
	@Test
	public void contextLoads() {
		System.out.println();
		String md5Pass = DigestUtils.md5DigestAsHex("qqqqqq".getBytes());
		System.out.println(md5Pass);
	}

}
