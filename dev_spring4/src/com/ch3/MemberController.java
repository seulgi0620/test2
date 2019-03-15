package com.ch3;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * void : pojo에서 처리하던 대로...
 * 		  res.sendRedirect("XXX.jsp"); |
 * 		    컨트롤러에서 또 다시 컨트롤러를 경유해야 하는 경우 - 게시판, 주문관리, 대여관리
 * 		    힌트 - 페이지의 흐름도(이동), ....
 * 		    조회 : jsp-jsp, jsp-action-jsp, jsp-action-action-jsp
 * 		    입력 : 도서관리-jsp(View)-저장버튼-action(Insert)-입력성공-action(select)-jsp
 * 		    수정
 * 		    삭제 
 * 		  res.sendRedirect("XXX.mvc");	
 * 		    생각해 보기 - 여기서 XXX.mvc도 사용이 가능할까?
 * 		  RequestDispatcher view = req.getRequestDispatcher("XXX.jsp");
 * 		  2번 연속(forward)은 불가하다
 * 		  RequestDispatcher view = req.getRequestDispatcher("XXX.mvc");
 * 	 	  view.forward(req, res);
 * 		  (2)ViewResolver - Spring
 * 		    화면 이름을 변경할 수 없음. - 화면이름은 요청이름과 같다.
 * 		    스프링을 사용해서 화면이름을 변경하고 싶을 땐 - ModelAndView
 * 		    아니면 POJO 하던 방식대로 하던가. - 이름을 바꿀 수 있다.
 * String
 * :ViewResolver가 관여하지 않음. - 배포위치 - WebContent
 * ModelAndView
 * :무조건 ViewResolver가 관여함. - 배포위치 - WEB-INF/view/
 */
@Controller
@RequestMapping("/ch3")
public class MemberController {
	Logger logger = Logger.getLogger(MemberController.class);
	@Autowired
	private MemberRegisterService mrService = null;
	
	private OrderLogic orderLogic = null;
	public void setOrderLogic(OrderLogic orderLogic) {
		this.orderLogic = orderLogic;
	}
	
	@GetMapping("regist")
	public String regist() {
		logger.info("regist호출 성공");
		//ViewResolver를 사용하지 않음.
		//따라서 jsp페이지의 배포 위치는 WEB-INF가 아니라 WebContent에 배포해야 함.
		return "redirect:registSuccess.jsp";
	}
	@GetMapping("test")
	public void test() {
		//응답페이지로 연결이 되어야 하나? 네
		//ViewResolver가 관여한다(WEB-INF아래) | 안한다(WebContent)
		orderLogic.methodA();
	}
}
