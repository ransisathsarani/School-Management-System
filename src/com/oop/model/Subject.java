package com.oop.model;

public class Subject {

	
	private int id;
	private String subjectNum;
	private String name;
	private String content;
	
	
	public Subject(int id, String subjectNum, String name, String content) {
		super();
		this.id = id;
		this.subjectNum = subjectNum;
		this.name = name;
		this.content = content;
	}


	public Subject(String subjectNum, String name, String content) {
		super();
		this.subjectNum = subjectNum;
		this.name = name;
		this.content = content;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSubjectNum() {
		return subjectNum;
	}


	public void setSubjectNum(String subjectNum) {
		this.subjectNum = subjectNum;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectNum=" + subjectNum + ", name=" + name + ", content=" + content + "]";
	}
}
