package com.evcinema.service.user.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

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

	//로그인 구현간 추가된 구현체
	@Override
	public String loginCheck(UserDto userDto, HttpSession session) {
		String name =userDao.loginCheck(userDto);
		 if (name != null) { // 세션 변수 저장
		  session.setAttribute("id", userDto.getId());
		  session.setAttribute("name", name);
		}
		 return name; 
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		 session.invalidate(); // 세션 초기화
	}
}
