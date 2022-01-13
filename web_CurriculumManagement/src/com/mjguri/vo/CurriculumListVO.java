package com.mjguri.vo;

public class CurriculumListVO {
	private String id;
	private String name;
	private int credit;
	private String lecturer;
	private int week;
	private String weekKR;
	
	
	public String getWeekKR() {
		return weekKR;
	}
	public void setWeekKR(String weekKR) {
		this.weekKR = weekKR;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getLecturer() {
		return lecturer;
	}
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	
}
