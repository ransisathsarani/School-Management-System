package com.oop.model;

public class Student {
	private int id;
	private String studentNum;
	private String fname;
	private String lname;
	private String BOD;
	private String number;
	private String grade;
	private String level;
	private String address;
	private String gender;
	
	public Student() {}

	public Student(String studentNum, String fname, String lname, String BOD, String number, String grade, String level,
			String address, String gender) {
		super();
		this.studentNum = studentNum;
		this.fname = fname;
		this.lname = lname;
		this.BOD=BOD;
		this.number = number;
		this.grade = grade;
		this.level = level;
		this.address = address;
	}

	public Student(int id, String studentNum, String fname, String lname, String BOD, String number, String grade,
			String level, String address, String gender) {
		super();
		this.id=id;
		this.studentNum = studentNum;
		this.fname = fname;
		this.lname = lname;
		this.BOD=BOD;
		this.number = number;
		this.grade = grade;
		this.level = level;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getBOD() {
		return BOD;
	}

	public void setBOD(String bOD) {
		BOD = bOD;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
