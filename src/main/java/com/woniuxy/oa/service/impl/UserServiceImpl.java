package com.woniuxy.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.mapper.UserMapper;
import com.woniuxy.oa.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public User getUserByAccount(String account) {
		User user=userMapper.selectUserByAccount(account);
		return user;
	}

	@Override
	public void addUser(String account, String password,Integer eid) {
		userMapper.insertUser(account,password,eid);
	}

}
