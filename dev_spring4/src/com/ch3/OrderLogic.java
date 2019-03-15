package com.ch3;

import org.apache.log4j.Logger;

public class OrderLogic {
	Logger logger = Logger.getLogger(OrderLogic.class);
	public void methodA() {
		logger.info("methodA 호출 성공");
	}
}
