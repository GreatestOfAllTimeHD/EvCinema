package com.evcinema.dao.customer.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
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


	SqlSession sqlSession; // 로그인 구현간 삽입 SqlSession 의존관계 주입
	 //로그인 interface 구현체 생성
	@Override
	public String loginCheck(UserDto UserDto) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("user.login_check", UserDto);
	}
	
}
