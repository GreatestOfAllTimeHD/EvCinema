package com.evcinema.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evcinema.dao.customer.UserDao;
import com.evcinema.dto.user.UserDto;
import com.evcinema.service.user.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public int saveUser(UserDto userDto) {
		// TODO Auto-generated method stub
		//if(userDto.getUserType()) {}
		
		int result = userDao.insertUser(userDto);
		
		return result;
	}

	@Override
	public List<UserDto> getUserList(UserDto userDto) {
		// TODO Auto-generated method stub
		
		List<UserDto> userList = userDao.selectUserList(userDto);
		
		return userList;
	}
}
