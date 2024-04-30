package com.food.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class User {
	private int userId;
	private String userName;
	private String password;
	private String email;
	private long phone;
	private String address;
	private String role;
	private LocalTime dateTime;
	private LocalDate lastlogindate;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userName, String password, String email, long phone, String address, String role,
			LocalTime dateTime, LocalDate lastlogindate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.dateTime = dateTime;
		this.lastlogindate = lastlogindate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalTime dateTime) {
		this.dateTime = dateTime;
	}

	public LocalDate getLastlogindate() {
		return lastlogindate;
	}

	public void setLastlogindate(LocalDate lastlogindate) {
		this.lastlogindate = lastlogindate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", role=" + role + ", dateTime=" + dateTime
				+ ", lastlogindate=" + lastlogindate + "]";
	}
	
	
}
