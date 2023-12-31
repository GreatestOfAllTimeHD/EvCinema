package com.evcinema.dao.customer.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evcinema.dao.customer.UserDao;
import com.evcinema.dto.user.UserDto;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int insertUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
		int result = sqlSessionTemplate.insert("user_mapper.insert_user", userDto);
		
		return result;
	}

	@Override
	public List<UserDto> selectUserList(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
