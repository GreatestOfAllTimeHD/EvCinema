package com.evcinema.service.room.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evcinema.dao.room.RoomDao;
import com.evcinema.dto.room.RoomDto;
import com.evcinema.service.room.RoomService;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	RoomDao roomDao;

	@Override
	public int saveRoom(RoomDto roomDto) {
		// TODO Auto-generated method stub
		roomDao.insertRoom(roomDto);
		
		return 0;
	}
}
