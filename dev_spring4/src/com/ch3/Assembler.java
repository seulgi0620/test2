package com.ch3;

public class Assembler {
	private MemberRegisterService mrService = null;
	private MemberDao memDao = null;

	public Assembler(){
		mrService = new MemberRegisterService();
		memDao = new MemberDao();
	}
	public void setMrService(MemberRegisterService mrService) {
		this.mrService = mrService;
	}
	public void setMemDao(MemberDao memDao) {
		this.memDao = memDao;
	}
}
