package com.evcinema.controller.customer;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.evcinema.dto.user.UserDto;
import com.evcinema.service.user.UserService;
import com.evcinema.utils.CommonCode;

@Controller
public class CustomerController {

	private static final Logger log = LogManager.getLogger(CustomerController.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping("/registerCustomer")
	public String registerCustomer() {
		
		return "registerCustomer";
	}
	
	@PostMapping("/registerCustomer")
	public String registerCustomer_process(UserDto userDto) {
		
		//userDto 안에 사용자가 입력한, id , name 들어있을것이다.
		userDto.setUserType(CommonCode.USER_USER_TYPE_CUSTOMER);
		int result = userService.saveUser(userDto);
		
		if(result > 0) {
			//정상 케이스
	        System.out.println("registerCustomer 입력 = "+result);
		} else {
			//뭔가 문제가 발생했다. -> 유효성 검증 -> 다른 페이지
		}
		
		return "registerCustomer";
	}
	
	//로그인 부분
	 // menu를 클릭하면 views/member/login.jsp로 이동 
	@RequestMapping("/login")
	 public String login() {
	  return "login";
	}

	@RequestMapping("/login_check")
	public ModelAndView login_check(@ModelAttribute UserDto userdto, HttpSession session) {
		System.out.println("1");
		String name = userService.loginCheck(userdto, session);  
		System.out.println("2");
		System.out.println(name);
	 ModelAndView mav = new ModelAndView();
	  if (name != null) { // 로그인 성공 시
	   mav.setViewName("index"); // 뷰의 이름
	   } else { // 로그인 실패 시
	     mav.setViewName("login"); 		
	     mav.addObject("message", "error");
	     }
	     return mav;
	   }
	   
	
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
	userService.logout(session); 
	 mav.setViewName("member/login"); 
	 mav.addObject("message", "logout"); 
	  return mav;
	  }
	
	@GetMapping("/customerList")
	public String customerList(Model model) {
		
		UserDto userDto = new UserDto();
		userDto.setUserType(CommonCode.USER_USER_TYPE_CUSTOMER);
		
		List<UserDto> userList = userService.getUserList(userDto);
		
		model.addAttribute("userList", userList);
		
		return "customerList";
	}
}




