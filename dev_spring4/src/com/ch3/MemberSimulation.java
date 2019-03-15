package com.ch3;
/*
 * MemberRegisterService와  MemberDao 두 클래스의 객체를 생성하고 주입하는것은 어디에서 해야 할까?
 * 로컬의 경우 : MemberSimulation이 객체 조립기의 역할을 함.
 * 웹의 경우 : 
 */
public class MemberSimulation {
	public static void main(String[] args) {
		MemberDao memDao = new MemberDao();
		MemberRegisterService mrs = new MemberRegisterService(memDao);
		mrs.regist();
	}
}
