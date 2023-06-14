package com.evcinema.controller.reserve_pay;

import java.util.HashMap; 
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.evcinema.dto.reservation.ReservationDto;
import com.evcinema.service.payment.PaymentService;
import com.evcinema.service.reservation.ReservationService;

@Controller
public class ReservationPaymentController {

	private static final Logger log = LogManager.getLogger(ReservationPaymentController.class);
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	ReservationService reservationService;
	
	
	@GetMapping("/reserveRoom")
	public String reserveRoom() {
		return "reserveRoom";
	}
	
	@PostMapping("/reserveRoom")
	public String reserveRoom_process(@ModelAttribute ReservationDto reservationDto) {
		
		System.out.println(reservationDto);
		int result = reservationService.createReservation(reservationDto);
		System.out.println(result);
		
		return "reserve_end";
	}
	
	@GetMapping("/reservationList")
	public String reservationList(Model model
								,@RequestParam(name="roomNumber", required = false) String roomNumber) {
		
		if(roomNumber == null) {
			List<ReservationDto> reservationList = reservationService.getReservationList();
			model.addAttribute("reservationList", reservationList);
		} else {
			ReservationDto reservationDto = new ReservationDto();
			reservationDto.setRoomNumber(roomNumber);
			List<ReservationDto> reservationList = reservationService.getReservationListByRoomNumber(reservationDto);
			model.addAttribute("reservationList", reservationList);
		}
		
		return "reservationList";
	}
	
	@GetMapping("/searchReservation")
	public String searchReservation(Model model, 
			@RequestParam(name="searchKeyword", required = false) String searchKeyword) {
		
		List<ReservationDto> reservationList = 
						reservationService.findReservationListBySearchKeyword(searchKeyword);
		model.addAttribute("reservationList", reservationList);
		
		return "searchReservation";
	}
	
	@GetMapping("/searchReservationMap")
	public String searchReservationMap(Model model,
			@RequestParam Map<String, String> map) {
			//@RequestParam(name="searchKeyword", required = false) String searchKeyword) { //1번 방식
		
		//방법 1. @RequestParam String searchKeyword 변수개별적으로 받기
		//방법 2. SearchCondition <- Dto 객체를 만들어서 요청변수 매핑
		//방법 3. Map<String,String> map 맵으로 받는 방법
		
		
//		Map<String, String> map = new HashMap<String, String>();   //1번 방식
//		map.put("searchKeyword", searchKeyword);
//		map.put("searchOption", "roomNumber customerNumber");
		
		List<ReservationDto> reservationList = 
						reservationService.findReservationListBySearchKeywordMap(map);
		model.addAttribute("reservationList", reservationList);
		
		return "searchReservation";
	}
	
	@GetMapping("/searchReservationMap2")
	public String searchReservationMap2(Model model,
			@RequestParam Map<String, String> map) {
		
		log.info("searchReservationMap2 info");
		log.error("{} search {} param map {}", "0번째위치", "1번째 위치", map);
		log.info("{} search {} param map {}", "0번째위치", "1번째 위치", map);
		log.error("searchReservationMap2 error");
		log.warn("searchReservationMap2 warn");
		log.debug("searchReservationMap2 debug");
		
		List<ReservationDto> reservationList = 
						reservationService.findReservationListBySearchKeywordMap2(map);
		model.addAttribute("reservationList", reservationList);
		
		log.debug("searchReservationMap2 end");
		
		return "searchReservation2";
	}
	
	
	
}






















