package com.dev.oops;

public class Human {

	private String name;
	private int age;
	private String designation;
	private String address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null) {
			throw new RuntimeException("Name should not be null");
		}
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age<=0) {
			throw new RuntimeException("Age should be greater than 0");
		}
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	void talk() {
		System.out.println("we are talking");
	}
	
	void walk() {
		
	}
}
