package com.woniuxy.oa.service;

import com.woniuxy.oa.entity.User;


public interface UserService {
	
	/**
	 * 根据用户名查用户
	 * @param uname
	 * @return User
	 */
	User getUserByAccount(String account);

	void addUser(String account,String password,Integer eid);
}
