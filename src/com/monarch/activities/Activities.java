package com.monarch.activities;

public class Activities {

	private int id;
	private String student_reg_num;
	private String sports;
	private String clubs;
	private String organizations;
	
	
	public Activities(int id, String student_reg_num, String sports, String clubs, String organizations) {
		super();
		this.id = id;
		this.student_reg_num = student_reg_num;
		this.sports = sports;
		this.clubs = clubs;
		this.organizations = organizations;
	}


	public Activities(String student_reg_num, String sports, String clubs, String organizations) {
		super();
		this.student_reg_num = student_reg_num;
		this.sports = sports;
		this.clubs = clubs;
		this.organizations = organizations;
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


	public String getSports() {
		return sports;
	}


	public void setSports(String sports) {
		this.sports = sports;
	}


	public String getClubs() {
		return clubs;
	}


	public void setClubs(String clubs) {
		this.clubs = clubs;
	}


	public String getOrganizations() {
		return organizations;
	}


	public void setOrganizations(String organizations) {
		this.organizations = organizations;
	}


	@Override
	public String toString() {
		return "Activities [id=" + id + ", student_reg_num=" + student_reg_num + ", sports=" + sports + ", clubs=" + clubs
				+ ", organizations=" + organizations + "]";
	}
	
}
