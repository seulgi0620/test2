package com.mvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value= {"/hello","/haha"})
public class HelloController {
	Logger logger = Logger.getLogger(HelloController.class);
	/*
	 * 질문
	 * ModelAndView와 Model의 차이점에 대해서 기술하시오.
	 * ModelAndView의 경우 DispatcherServlet에게 전달되는 객체이고
	 * Model의 경우 화면 출력을 위해서 제공되는 클래스로 설계되었다.
	 * ModelAndView는 클래스이고 Model은 인터페이스 임.
	 * ModelAndView는 화면 이름을 설정할 수 있지만 Model은 불가함.
	 * ModelAndView는 반환타입으로써 사용하고 Model은 파라미터로 활용됨.
	 * ModelAndView는 개발자가 직접 객체 생성을 함(제어역행이 아님)
	 * Model은 프레임워크에서 객체 주입을 받음. (제어역행임)
	 * 공통점
	 * scope가 동일함.
	 * 화면에 필요한 정보를 담아서 넘길 수 있음.
	 * 화면처리에 관련한 작업 정보를 담을 수 있음.
	 * 둘 다 스프링에서 제공하는 API임.
	 * 
	 */
	@GetMapping("methodF.kos")
	public void methodF(Model model, HttpServletResponse res, HttpServletRequest req) throws Exception {
		logger.info("methodF호출 성공");
		//Model mod = new Model();
		//HelloController에서 가진 정보를 jsp페이지에서도 유지하거나 공유하고 싶다.
		//어떡하지?
		String msg = "apple";
		ModelAndView mav = new ModelAndView();
		model.addAttribute("msg",msg);
		mav.addObject("msg2",msg);
		req.setAttribute("msg3", msg);
		//질문:이런 조건(리다이렉트)일 때 정보를 유지할 수 있다? 없다?
		//res.sendRedirect("./methodF.jsp");
		RequestDispatcher view = req.getRequestDispatcher("./methodF.jsp");
		view.forward(req, res);
	}
	/*
	 * 화면 이름을 지정하지 않았을 경우 - ViewResolver
	 * 화면이름이 없을 경우 요청의 이름이 화면의 이름이 된다.
	 * 질문1
	 * 출력된 화면과 URL정보가 일치하나요?
	 * 결론
	 * 스프링3.0 이후 버전에서는 디폴트가  forward 입니다.
	 * 화면 처리에 ViewResolver가 무조건 관여하게 된다는 거죠.
	 * 질문2
	 * 만일 WebContent 아래 있는 페이지를 요청해야 할 땐 어떡하지? how?
	 * 단, 반드시 Dispatcher서블릿을 경유해서 페이지를 요청해야 한다.
	 */
	@RequestMapping(value="/methodE", method=RequestMethod.GET)
	public void methodE(HttpServletResponse res) throws Exception {
		logger.info("methodE호출 성공");
		Cookie cook = new Cookie("mem_id","test");
		cook.setMaxAge(60);
		res.addCookie(cook);
		res.sendRedirect("./methodE.jsp");
	}
	
	@GetMapping("/methodD")
	public void methodD() {
		logger.info("methodD호출 성공");
	}
	
	@GetMapping("/methodC")
	public ModelAndView methodC() {
		logger.info("methodC호출 성공");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello/methodC");
		return mav;
	}
	
	@GetMapping("/methodB")
	public void methodB() {
		logger.info("methodB호출 성공");
	}
	@RequestMapping(value="helloSpring.kos")
	public void insa() {
		logger.info("insa 호출 성공");
	}
	@RequestMapping(value="good")
	public void methodA() {
		logger.info("haha good 호출 성공");
	}
}
