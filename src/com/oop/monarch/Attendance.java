package com.oop.monarch;

public class Attendance {

	private int id;
	private String year;
	private String classroom;
	private String date;
	private String present;
	private String absent;
	
	public Attendance(int id, String year, String classroom, String date, String present, String absent) {
		super();
		this.id = id;
		this.year = year;
		this.classroom = classroom;
		this.date = date;
		this.present = present;
		this.absent = absent;
	}

	public Attendance(String year, String classroom, String present, String absent) {
		super();
		this.year = year;
		this.classroom = classroom;
		this.present = present;
		this.absent = absent;
	}

	public Attendance(String year, String classroom, String date, String present, String absent) {
		super();
		this.year = year;
		this.classroom = classroom;
		this.date = date;
		this.present = present;
		this.absent = absent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPresent() {
		return present;
	}

	public void setPresent(String present) {
		this.present = present;
	}

	public String getAbsent() {
		return absent;
	}

	public void setAbsent(String absent) {
		this.absent = absent;
	}
	
	
	
	
}
