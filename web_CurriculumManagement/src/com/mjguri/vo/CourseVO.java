package com.mjguri.vo;

public class CourseVO {
	private String id;
	private String name;
	private int credit;
	private int lecturer;
	private int week;
	private int starthour;
	private int endhour;
	
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
	public int getLecturer() {
		return lecturer;
	}
	public void setLecturer(int lecturer) {
		this.lecturer = lecturer;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getStarthour() {
		return starthour;
	}
	public void setStarthour(int starthour) {
		this.starthour = starthour;
	}
	public int getEndhour() {
		return endhour;
	}
	public void setEndhour(int endhour) {
		this.endhour = endhour;
	}

}
