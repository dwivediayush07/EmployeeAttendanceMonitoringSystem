package com.employee.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Attendance {
	@Id
	private int empId;
	private int totalPresent;
	private int totalAbsent;
	private int workingDays;

	// Getter and Setter
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getTotalPresent() {
		return totalPresent;
	}

	public void setTotalPresent(int totalPresent) {
		this.totalPresent = totalPresent;
	}

	public int getTotalAbsent() {
		return totalAbsent;
	}

	public void setTotalAbsent(int totalAbsent) {
		this.totalAbsent = totalAbsent;
	}

	public int getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}

	// toString
	@Override
	public String toString() {
		return "Attendance [empId=" + empId + ", totalPresent=" + totalPresent + ", totalAbsent=" + totalAbsent
				+ ", workingDays=" + workingDays + "]";
	}

	// Constructors form SuperClass
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructor using Fields
	public Attendance(int empId, int totalPresent, int totalAbsent, int workingDays) {
		super();
		this.empId = empId;
		this.totalPresent = totalPresent;
		this.totalAbsent = totalAbsent;
		this.workingDays = workingDays;
	}

	// hashCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + totalAbsent;
		result = prime * result + totalPresent;
		result = prime * result + workingDays;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attendance other = (Attendance) obj;
		if (empId != other.empId)
			return false;
		if (totalAbsent != other.totalAbsent)
			return false;
		if (totalPresent != other.totalPresent)
			return false;
		if (workingDays != other.workingDays)
			return false;
		return true;
	}

}
