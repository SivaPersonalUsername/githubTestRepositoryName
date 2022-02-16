package com.beans;

public class Employee {
private String name;
private String city;
private String designation;


public Employee() {
}
@Override
public String toString() {
	return "Employee [name=" + name + ", city=" + city + ", designation=" + designation + "]";
}
public Employee(String name, String city, String designation) {
	super();
	this.name = name;
	this.city = city;
	this.designation = designation;
}
public String getName() {
	return name;
}
public String getCity() {
	return city;
}
public String getDesignation() {
	return designation;
}



}
