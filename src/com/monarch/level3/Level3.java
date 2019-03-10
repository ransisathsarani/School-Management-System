package com.monarch.level3;

public class Level3 {
	
	private int id;
	private String student_reg_num;
	private String stream;
	private String subject1;
	private String subject2;
	private String subject3;
	
	public Level3(int id, String student_reg_num, String stream, String subject1, String subject2, String subject3) {
		super();
		this.id = id;
		this.student_reg_num = student_reg_num;
		this.stream = stream;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
	}

	public Level3(String stream, String student_reg_num,  String subject1, String subject2, String subject3) {
		super();
		this.student_reg_num = student_reg_num;
		this.stream = stream;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudent_reg_num() {
		return student_reg_num;
	}

	public void setStudent_reg_num(String student_reg_num) {
		this.student_reg_num = student_reg_num;
	}
	
	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getSubject1() {
		return subject1;
	}

	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}

	public String getSubject2() {
		return subject2;
	}

	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}

	public String getSubject3() {
		return subject3;
	}

	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}

	@Override
	public String toString() {
		return "Level3 [id=" + id + ", student_reg_num=" + student_reg_num + ", stream=" + stream + ", subject1="
				+ subject1 + ", subject2=" + subject2 + ", subject3=" + subject3 + "]";
	}

	

	

}
