package com.dev.java;

public class Car {

	private String color;
	private String regNum;
	private String model;
	private String brand;
	private boolean isSedan;
	private int age;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getRegNum() {
		return regNum;
	}
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public boolean isSedan() {
		return isSedan;
	}
	public void setSedan(boolean isSedan) {
		this.isSedan = isSedan;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age < 0) {
			throw new RuntimeException("Age should be greater than 0");
		}
		this.age = age;
	}
	
	void move() {
		
	}
	
	public static void main(String[] args) {
		Car i20 = new Car();
		//i20.age = -10;
		i20.setAge(10);
		i20.setBrand("Hyundai");
		i20.setColor("red");
		i20.setSedan(true);
		System.out.println(i20.getAge());
		System.out.println(i20.getBrand());
		System.out.println(i20.getColor());
		System.out.println(i20.isSedan());
	}
}
