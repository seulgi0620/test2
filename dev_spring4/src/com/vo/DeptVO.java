package com.vo;

public class DeptVO {
	private int deptno = 0; //원시형 타입의 경우 제외대상
	private String dname = null; //null로 초기화 하는 경우 값을 꺼낼 때 NullPointerException 발생 가능.
	private String loc = null;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
