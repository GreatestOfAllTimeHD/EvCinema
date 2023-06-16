package com.evcinema.controller.room;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.evcinema.dto.room.RoomDto;
import com.evcinema.service.room.RoomService;

@Controller
	public class RoomController {
		
	@Autowired
	RoomService roomService;
	
	@GetMapping("/registerRoom")
	public String registerRoom() {
		
		return "registerRoom";
	}
	
	@PostMapping("/registerRoom")
	public String registerRoom_process(RoomDto roomDto) {
		
		roomService.saveRoom(roomDto);
		
		return "registerRoom";
	}
}
