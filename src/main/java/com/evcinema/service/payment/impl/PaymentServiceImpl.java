package com.evcinema.service.payment.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evcinema.dao.payment.PaymentDao;
import com.evcinema.dao.reservation.ReservationDao;
import com.evcinema.dao.sales.SalesDao;
import com.evcinema.dto.payment.PaymentDto;
import com.evcinema.dto.reservation.ReservationDto;
import com.evcinema.service.payment.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentDao paymentDao;
	
	@Autowired
	ReservationDao reservationDao;
	
	@Autowired
	SalesDao salesDao;

	@Override
	public int payRoomByCustomer(PaymentDto paymentDto, ReservationDto reservationDto) { //어느방을, 누가, 어느날짜예약정보...
		// TODO Auto-generated method stub
		
		//결제 처리!!
		
		//결제 성공 시,
		//paymentDao -> 결제정보 저장
		//salesDao -> 매출 정보 등록
		//reservationDao -> 예약정보 수정 (예약된 방 상태 변경 : 결제대기 -> 결제완료)
		
		return 0;
	}
	
	
}
