package com.woniuxy.oa.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.woniuxy.oa.entity.User;

@Mapper
public interface UserMapper {
	User selectUserByAccount(String account);
	
	void insertUser(@Param("account")String account, @Param("password")String password,@Param("eid")Integer eid);

	void updatePasswordByAccount(@Param("account")String account, @Param("password") String newpwd);
}
