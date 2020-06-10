package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
 private  String Name;
 private String mobile ,email, Address,password,grades,attendance;
 private int fee,paid,due;
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mob)
{
	mobile=mob;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGrades() {
	return grades;
}
public void setGrades(String grades) {
	this.grades = grades;
}
public String getAttendance() {
	return attendance;
}
public void setAttendance(String attendance) {
	this.attendance = attendance;
}
public int getFee() {
	return fee;
}
public void setFee(int fee) {
	this.fee = fee;
}
public int getPaid() {
	return paid;
}
public void setPaid(int paid) {
	this.paid = paid;
}
public int getDue() {
	return due;
}
public void setDue(int due) {
	this.due = due;
}
 
}
