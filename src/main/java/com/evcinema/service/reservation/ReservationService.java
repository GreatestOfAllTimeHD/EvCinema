package com.evcinema.service.reservation;

import java.util.List;
import java.util.Map;

import com.evcinema.dto.reservation.ReservationDto;

public interface ReservationService {

	public int createReservation(ReservationDto reservationDto);
	
	public List<ReservationDto> getReservationList();
	
	public List<ReservationDto> getReservationListByRoomNumber(ReservationDto reservationDto);
	
	public List<ReservationDto> findReservationListBySearchKeyword(String searchKeyword);
	
	public List<ReservationDto> findReservationListBySearchKeywordMap(Map<String, String> map);
	
	public List<ReservationDto> findReservationListBySearchKeywordMap2(Map<String, String> map);
}
