package com.vo;

public class BoardSubVO {

	private int 	bs_seq   =0; 
	private String 	bs_fname =""; 
	private double 	bs_fsize =0.0; 
	private int		bm_no    =0;
	public int getBs_seq() {
		return bs_seq;
	}
	public void setBs_seq(int bs_seq) {
		this.bs_seq = bs_seq;
	}
	public String getBs_fname() {
		return bs_fname;
	}
	public void setBs_fname(String bs_fname) {
		this.bs_fname = bs_fname;
	}
	public double getBs_fsize() {
		return bs_fsize;
	}
	public void setBs_fsize(double bs_fsize) {
		this.bs_fsize = bs_fsize;
	}
	public int getBm_no() {
		return bm_no;
	}
	public void setBm_no(int bm_no) {
		this.bm_no = bm_no;
	}
	
}
