package com.app.entities;

public class Student {
	private int rollNo;
	private String name;
	private String course;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int rollNo, String name, String course) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.course = course;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", course=" + course + "]";
	}

}
