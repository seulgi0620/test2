package com.mvc;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class LoginDao {
	Logger logger = Logger.getLogger(LoginDao.class);
	SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public String login(String p_id, String p_pw) {
		logger.info("login 호출 성공");
		String mem_name = "";
		Map<String,Object> pMap = new HashMap<String,Object>();
		pMap.put("mem_id", p_id);
		pMap.put("mem_pw", p_pw);
		sqlSessionTemplate.selectOne("proc_login", pMap);
		//프로시저의 OUT속성의 값을 파라미터 타입을 통해서 읽어올 수 있다.
		logger.info("OUT속성에 저장된 값"+pMap.get("r_name"));
		mem_name = pMap.get("r_name").toString();
		return mem_name;
	}
	

}
