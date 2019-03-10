package com.monarch.level2;

public class Level2 {

	
	private int id;
	private String student_reg_num;
	private String option1;
	private String option2;
	private String option3;
	
	
	public Level2(String student_reg_num, String option1, String option2, String option3) {
		this.student_reg_num = student_reg_num;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
	}


	public Level2(int id, String student_reg_num, String option1, String option2, String option3) {
		this.id = id;
		this.student_reg_num = student_reg_num;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
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


	public String getOption1() {
		return option1;
	}


	public void setOption1(String option1) {
		this.option1 = option1;
	}


	public String getOption2() {
		return option2;
	}


	public void setOption2(String option2) {
		this.option2 = option2;
	}


	public String getOption3() {
		return option3;
	}


	public void setOption3(String option3) {
		this.option3 = option3;
	}


	@Override
	public String toString() {
		return "Level2 [id=" + id + ", student_reg_num=" + student_reg_num + ", option1=" + option1 + ", option2="
				+ option2 + ", option3=" + option3 + "]";
	}
	

}
