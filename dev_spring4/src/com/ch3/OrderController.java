package com.ch3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*
 * void일때 배포위치
 * String일때 배포위치
 * ModelAndView일때 배포위치
 */
@Controller
@RequestMapping("/ch3")
public class OrderController {
	@GetMapping("getOrderList")
	public ModelAndView getOrderList() {
		ModelAndView mav = new ModelAndView();
		//아래 화면은 어떤 경로에 배치를 해야 할까요?
		//결론: ModelAndView에 화면이름을 지정한 경우에는 ViewResolver클래스를 사용해요.
		//왜냐하면 스프링을 사용하면 스프링이 모든 일을 관장하는데 응담페이지에 대한 요청도
		//그 중에 한가지이죠.
		//따라서 ModelAndView에 담긴 모든 정보는 DispatcherServlet에 전달되고
		//전달된 화면이름을 ViewResolver클래스에게 보내서 url패턴을 완성시켜요.
		//위치는 spring-servlet.xml
		//접두어:/WEB-INF/view/  접미어: .jsp
		//그리고 그 값을 리턴받아서 페이지를 호출합니다.
		//누가? DispatcherServlet
		mav.setViewName("ch3/getOrderList");
		return mav;
	}
	
}
