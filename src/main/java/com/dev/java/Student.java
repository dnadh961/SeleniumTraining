package com.dev.java;

public class Student {

	private String name;
	private String degree;
	private String location;
	private int age;
	private boolean isMarried;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	void attendClasses() {
		
	}
	
	void makeNotes() {
		
	}
	
	void practice() {
		System.out.println("I am practicing");
	}
	
	void doHomeWork() {
		System.out.println("I am doing home work");
	}
	
	void play() {
		
	}
	
	public static void main(String[] args) {
		Student chandra = new Student();
		chandra.setAge(30);
		chandra.setName("Chandra Lekha");
		chandra.setLocation("US");
		chandra.setMarried(false);
		System.out.println(chandra.getAge());
		System.out.println(chandra.getName());
		System.out.println(chandra.getLocation());
		System.out.println(chandra.isMarried());
		chandra.doHomeWork();
		
		Student kiran = new Student();
		kiran.setAge(30);
		kiran.setName("Kiran");
		kiran.setLocation("US");
		kiran.setMarried(true);
		kiran.practice();
		
		Student supriya = new Student();
		supriya.setAge(30);
		supriya.setName("Supriya");
		supriya.setLocation("US");
		supriya.setMarried(true);
		
		Student sirisha = new Student();
		sirisha.setAge(30);
		sirisha.setName("Sirisha");
		sirisha.setLocation("US");
		sirisha.setMarried(true);
	}
	
}
