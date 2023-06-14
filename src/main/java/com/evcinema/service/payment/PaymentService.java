package com.evcinema.service.payment;

import com.evcinema.dto.payment.PaymentDto;
import com.evcinema.dto.reservation.ReservationDto;

public interface PaymentService {
	public int payRoomByCustomer(PaymentDto paymentDto, ReservationDto reservationDto);
								//얼마...				//누가 어느 방을 예약했는지
}
