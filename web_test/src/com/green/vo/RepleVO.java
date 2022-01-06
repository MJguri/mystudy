package com.green.vo;

import java.sql.Timestamp;

public class RepleVO {
	private int c_code;
	private int b_code;
	private String c_user;
	private String c_comment;
	private String c_password;
	private Timestamp c_regdate;
	public int getC_code() {
		return c_code;
	}
	public void setC_code(int c_code) {
		this.c_code = c_code;
	}
	public int getB_code() {
		return b_code;
	}
	public void setB_code(int b_code) {
		this.b_code = b_code;
	}
	public String getC_user() {
		return c_user;
	}
	public void setC_user(String c_user) {
		this.c_user = c_user;
	}
	public String getC_comment() {
		return c_comment;
	}
	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}
	public String getC_password() {
		return c_password;
	}
	public void setC_password(String c_password) {
		this.c_password = c_password;
	}
	public Timestamp getC_regdate() {
		return c_regdate;
	}
	public void setC_regdate(Timestamp c_regdate) {
		this.c_regdate = c_regdate;
	}
	
	

}
