package com.evcinema.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.evcinema.dto.user.UserDto;
import com.evcinema.utils.CommonCode;

public class LoginInterceptor implements HandlerInterceptor{
	
	//Controller 진입하기 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {//요청정보를 미리 처리할 수 있음.
		// TODO Auto-generated method stub
		
		// Controller로 넘어가기 전 처리할 로직을 작성해주는곳
		// 이곳이 처리하는 중추
		// sesstion처리 할때 boolean값을 받는다고 하는 것이 있음
		
		HttpSession session = request.getSession(false);
		// 1차 : Session 있나? 
		// 2차 : Session 안에 로그인 정보가 있나?
		if(session == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return false;//false로 막아버린 상태임
			// 인터셉터 return false
			// 이 다음 진행 하지 않아
		}
		
		//이전에 로그인 성공 session.setAttribute("loginUser", user);
		UserDto user = (UserDto) session.getAttribute("loginUser");
		if(user == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		
		//getSession 있나 없나 -> 없어? -> 만듬
		//getSession(false) 있나 없나 -> 없다? -> null (안만들고)
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	//요청 -> preHandel -> Controller(service, dao, db) 
	//      -> postHandle ->view -> afterCompletion -> 응답
	
	//Controller 처리 후 View 처리 전
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	//View 처리 후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
