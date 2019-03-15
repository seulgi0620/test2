package com.mvc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.util.HashMapBinder;
import com.vo.MemberVO;

@Controller
@RequestMapping("/ch9/member")
public class MemberController2 {
	Logger logger = Logger.getLogger(MemberController2.class);
	
	@GetMapping("/memberAdd")
	public void memberAdd(HttpServletRequest req) { //HashMapBinder를 활용할 때
		logger.info("memberAdd 호출 성공");
		HashMapBinder hmb = new HashMapBinder(req);
		Map<String,Object> target = new HashMap<String,Object>();
		hmb.bind(target);
		Object keys[] = target.keySet().toArray();
		for(int i=0; i<keys.length; i++) {
			String key = keys[i].toString();
			logger.info(target.get(key));
		}
	}
	
	@GetMapping("/memberAdd2")
	public void memberAdd2(@ModelAttribute MemberVO emVO) { //ModelAttribute를 활용할 때
		logger.info("memberAdd2 호출 성공");
		logger.info("이름:" + emVO.getMem_name());	
		logger.info("HP:" + emVO.getMem_hp());	
		logger.info("비번:" + emVO.getMem_pw());	
		}
	
			
}
