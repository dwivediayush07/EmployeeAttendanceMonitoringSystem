package com.employee.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	private int adminId;
	private String name;
	private String password;

	// Getter
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	// toString
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", password=" + password + "]";
	}

	// Constructor from SuperClass
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

}