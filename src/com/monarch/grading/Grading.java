package com.monarch.grading;

public class Grading {

	private int id;
	private String SID;
	private String level;
	private String examID;
	private String sub1;
	private String sub2;
	private String sub3;
	private String sub4;
	private String sub5;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSID() {
		return SID;
	}
	public void setSID(String SID) {
		this.SID = SID;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getExamID() {
		return examID;
	}
	public void setExamID(String examID) {
		this.examID = examID;
	}
	public String getSub1() {
		return sub1;
	}
	public void setSub1(String sub1) {
		this.sub1 = sub1;
	}
	public String getSub2() {
		return sub2;
	}
	public void setSub2(String sub2) {
		this.sub2 = sub2;
	}
	public String getSub3() {
		return sub3;
	}
	public void setSub3(String sub3) {
		this.sub3 = sub3;
	}
	public String getSub4() {
		return sub4;
	}
	public void setSub4(String sub4) {
		this.sub4 = sub4;
	}
	public String getSub5() {
		return sub5;
	}
	public void setSub5(String sub5) {
		this.sub5 = sub5;
	}

	
	public Grading(String SID, String level, String examID, String sub1, String sub2, String sub3, String sub4,
			String sub5) {
		super();
	
		this.SID = SID;
		this.level = level;
		this.examID = examID;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.sub4 = sub4;
		this.sub5 = sub5;
	}
	
	public Grading(int id, String SID, String level, String examID, String sub1, String sub2, String sub3, String sub4,
			String sub5) {
		super();
		this.id = id;
		this.SID = SID;
		this.level = level;
		this.examID = examID;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.sub4 = sub4;
		this.sub5 = sub5;
	}
	
	public Grading() {}
	@Override
	public String toString() {
		return "Grading [id=" + id + ", SID=" + SID + ", level=" + level + ", examID=" + examID + ", sub1=" + sub1
				+ ", sub2=" + sub2 + ", sub3=" + sub3 + ", sub4=" + sub4 + ", sub5=" + sub5 + "]";
	}
	
	
	
}
