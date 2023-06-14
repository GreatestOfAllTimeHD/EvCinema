package com.evcinema.dao.reservation;

import java.util.List; 
import java.util.Map;

import com.evcinema.dto.reservation.ReservationDto;

public interface ReservationDao {

	public int insertReservation(ReservationDto reservationDto);
	
	public List<ReservationDto> selectReservationList();
	
	public List<ReservationDto> selectReservationListByRoomNumber(ReservationDto reservationDto);
	
	public List<ReservationDto> selectReservationListBySearchKeyword(String searchKeyword); 
	
	public List<ReservationDto> selectReservationListBySearchKeywordMap(Map<String, String> map);
	
	public List<ReservationDto> selectReservationListBySearchKeywordMap2(Map<String, String> map);
}
