package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.istack.internal.logging.Logger;

@Controller
@RequestMapping(value="/dept")
public class DeptController {
	Logger logger = Logger.getLogger(DeptController.class);
	@RequestMapping(value="getDeptList")
	public ModelAndView getDeptList() {
		logger.info("getDeptList 호출 성공");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("dept/getDeptList");//화면이름이다.
		String msg = "오늘 뭐해?";
		mav.addObject("msg",msg); // request
		return mav;
	}
}
