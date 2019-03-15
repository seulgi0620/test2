package com.mvc;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginLogic {
	Logger logger = Logger.getLogger(LoginLogic.class);
	@Autowired
	LoginDao loginDao = null;
	public String login(String p_id, String p_pw) {
		logger.info("login 메소드 호출 성공");
		String mem_name = "";
		mem_name = loginDao.login(p_id, p_pw);
		return mem_name;
	}

}
