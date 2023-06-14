package com.evcinema.service.reservation.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evcinema.dao.reservation.ReservationDao;
import com.evcinema.dto.reservation.ReservationDto;
import com.evcinema.service.reservation.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	
	@Autowired
	ReservationDao reservationDao;
	
	@Override
	public int createReservation(ReservationDto reservationDto) {
		// TODO Auto-generated method stub
		
		//호텔 객실 정보 유효성 체크...
		
		//예약 정보 새로 생성
		int result = reservationDao.insertReservation(reservationDto);
		
		return result;
	}

	@Override
	public List<ReservationDto> getReservationList() {
		// TODO Auto-generated method stub
		
		List<ReservationDto> list = reservationDao.selectReservationList();
		
		return list;
	}
	
	@Override
	public List<ReservationDto> getReservationListByRoomNumber(ReservationDto reservationDto) {
		// TODO Auto-generated method stub
		
		List<ReservationDto> list = reservationDao.selectReservationListByRoomNumber(reservationDto);
		
		return list;
	}

	@Override
	public List<ReservationDto> findReservationListBySearchKeyword(String searchKeyword) {
		// TODO Auto-generated method stub
		List<ReservationDto> list = reservationDao.selectReservationListBySearchKeyword(searchKeyword);
		
		return list;
	}

	@Override
	public List<ReservationDto> findReservationListBySearchKeywordMap(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<ReservationDto> list = reservationDao.selectReservationListBySearchKeywordMap(map);
		
//		String option = map.get("searchOption");
//		if(option.equals("customerNumber")) {
//			reservationDao.selectReservationListBySearchKeywordMapCustomerNumber(map);
//		} else {
//			reservationDao.selectReservationListBySearchKeywordMapRoomNumber(map);
//		}
		
		return list;
	}

	@Override
	public List<ReservationDto> findReservationListBySearchKeywordMap2(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<ReservationDto> list = reservationDao.selectReservationListBySearchKeywordMap2(map);
		
		return list;
	}

	
}




















