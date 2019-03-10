package com.oop.model;

public class Teacher {

	private int id;
	private String staffid;
	private String name;
	private String subjectNum;
	private String email;
	private String password;
	private String number;
	
	public Teacher() {}

	public Teacher(String staffid, String name, String subjectNum, String email, String password, String number) {
		super();
		this.setStaffid(staffid);
		this.setName(name);
		this.setSubjectNum(subjectNum);
		this.setEmail(email);
		this.setPassword(password);
		this.setNumber(number);
	}

	public Teacher(int id, String staffid, String name, String subjectNum, String email, String password,
			String number) {
		super();
		this.setId(id);
		this.setStaffid(staffid);
		this.setName(name);
		this.setSubjectNum(subjectNum);
		this.setEmail(email);
		this.setPassword(password);
		this.setNumber(number);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubjectNum() {
		return subjectNum;
	}

	public void setSubjectNum(String subjectNum) {
		this.subjectNum = subjectNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
}
