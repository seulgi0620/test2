package com.mvc;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vo.MemberVO;

@Controller
//@Service
@RequestMapping(value = "/ch9/member")
public class LoginController {
	Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	LoginLogic loginLogic = null;
	/******************************************************************************************************
	 * @param model : 화면에서 사용할 객체를 전달하는 객체
	 * @param bm_email : RequestParam을 사용하면 한 번에 한 개만 요청할 수 있으므로 불편함.
	 * @param mvo : @ModelAttribute를 사용하면 VO를 파라미터로 하여 한 번에 여러개의 값을 전달
	 * 				POJO에서 만들었던 HashMapBinder를 대신할 수 있음.
	 * @param pMap : @ModelAttribute는 VO타입은 지원하지만 Map타입은 지원하지 않음.
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 ******************************************************************************************************/

	@GetMapping("/login")
	public ModelAndView login(Model model, @RequestParam(value = "name", required = false) String bm_email,
			@ModelAttribute("formData") MemberVO mvo,
			@ModelAttribute("pMap") HashMap<String,Object> pMap,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("login 메소드 호출 성공"); // log4j.properties class, method, line
		logger.info("bm_email:" + bm_email);
		logger.info("mem_name:" + mvo.getMem_name());
		logger.info("mem_addr:" + mvo.getMem_addr());
		logger.info("pMap.get(mem_name):" + pMap.get("mem_name"));
		logger.info("pMap.get(mem_addr):" + pMap.get("mem_addr"));
		logger.info("mem_addr:" + mvo.getMem_addr());
		String mem_name = "";// DB에서 조회된 결과를 담기 - 이름
		String p_id = req.getParameter("mem_id");
		String p_pw = req.getParameter("mem_pw");
		mem_name = loginLogic.login(p_id, p_pw);
		Cookie cook = new Cookie("cmem_name", mem_name);
		cook.setPath("/");
		// redirect이거나 forward이거나 상관없이 유지 - 기억
		cook.setMaxAge(60);// 1분동안 유지
		res.addCookie(cook);
		// return "redirect:/ch9/member/loginForm.jsp";
		ModelAndView mav = new ModelAndView();// ViewResolver
		mav.setViewName("ch9/member/loginForm");
		return mav;
	}

}
