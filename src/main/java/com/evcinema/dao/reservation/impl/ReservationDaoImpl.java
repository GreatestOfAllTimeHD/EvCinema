package com.evcinema.dao.reservation.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evcinema.dao.reservation.ReservationDao;
import com.evcinema.dto.reservation.ReservationDto;

@Repository
public class ReservationDaoImpl implements ReservationDao  {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int insertReservation(ReservationDto reservationDto) {
		
		int result = sqlSessionTemplate.insert("reservation_mapper.insert_reservation", reservationDto);
		
		return result;
	}

	@Override
	public List<ReservationDto> selectReservationList() {
		// TODO Auto-generated method stub
		List<ReservationDto> list = 
				sqlSessionTemplate.selectList("reservation_mapper.select_reservation_list");
		
		return list;
	}
	
	@Override
	public List<ReservationDto> selectReservationListBySiteId(ReservationDto reservationDto) {
		// TODO Auto-generated method stub
		List<ReservationDto> list = 
				sqlSessionTemplate.selectList("reservation_mapper.select_reservation_list_by_siteId", reservationDto);
		
		//Ctrl+H 전체에서 검색하기
		//Ctrl+Shift+R 파일 찾기
		
		
		return list;
	}

	@Override
	public List<ReservationDto> selectReservationListBySearchKeyword(String searchKeyword) {
		// TODO Auto-generated method stub
		List<ReservationDto> list = 
				sqlSessionTemplate.selectList("reservation_mapper.select_reservation_list_by_searchKeyword", searchKeyword);
		
		return list;
	}

	@Override
	public List<ReservationDto> selectReservationListBySearchKeywordMap(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<ReservationDto> list = 
				sqlSessionTemplate.selectList("reservation_mapper.select_reservation_list_by_searchKeyword_map", map);
		
		return list;
	}

	@Override
	public List<ReservationDto> selectReservationListBySearchKeywordMap2(Map<String, String> map) {
		// TODO Auto-generated method stub
		List<ReservationDto> list = 
				sqlSessionTemplate.selectList("reservation_mapper.select_reservation_list_by_searchKeyword_map2", map);
		
		return list;
	}
	
	
	
	
	
	/* 
	 //2차 프로젝트시, 수동으로 처리했던 부분
	@Override
	public int insertReservation(ReservationDto reservationDto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		
		int cnt = 0;
		
		//DB에 예약정보를 저장!!
		try {
			conn = DBConnectionManager.getConnection();
			
			String sql = "insert into T_RESERVATION " 
						+" VALUES( ?, ? )";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, reservationDto.getRoomNumber());
			psmt.setString(2, reservationDto.getCustomerNumber());
			
			cnt = psmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBConnectionManager.close(null, psmt, conn);
		}
		
		
		return cnt;
	}
	*/

}
