package com.ch3;

import org.springframework.stereotype.Service;

/*
 * 학습목표
 * 나는 의존의 정의에 대해 말할 수 있다.
 * 
 * 생각해보기
 * MemberRegisterService객체가 생성될 때 MemberDao는 같이 생성되는가? 됨.
 * MemberRegisterService mrs = new MemberRegisterService();
 * MemberRegisterService mrs = new MemberRegisterService(MemberDao mDao);
 * 
 * 두번째 생각해 볼 문제
 * 이 두 개의 클래스를 테스트 해 보고 싶다.
 * 어떡하지?
 */
@Service
public class MemberRegisterService {
	//MemberDao memDao = new MemberDao();
	MemberDao memDao = null;
	public MemberRegisterService() {
		
	}
	public MemberRegisterService(MemberDao memDao) {
		this.memDao = memDao;
	}
	public void regist() {
		System.out.println("MemberRegisterService regist호출 성공");
		/*
		 * 이렇게 한 클래스(MemberRegisterService)가 다른 클래스(MemberDao)의 
		 * 메소드를 실행할 때 의존이라고 함.
		 * 최초에는 희상이가 regist()이름으로 메소드를 선언하였으나
		 * 후에 registAdd()로 메소드이름을 변경하였음. - 변경점 발생.
		 */
		memDao.registAdd();
	}
	
}
