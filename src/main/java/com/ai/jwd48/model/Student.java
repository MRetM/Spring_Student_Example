package com.ai.jwd48.model;

public class Student {

	private int id;
	private String name;
	private String email;
	private int age;
	private String address;
	private String phoneNumber;
	private String fatherName;
	private String gender;
	//private String batchName;

	public Student() {
	}

	public Student(int id, String name, String email, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.address = address;
		this.fatherName = fatherName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		//this.batchName = batchName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
//
//	public String getBatchName() {
//		return batchName;
//	}
//
//	public void setBatchName(String batchName) {
//		this.batchName = batchName;
//	}

}
