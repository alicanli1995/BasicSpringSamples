package com.example.hr.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.example.hr.domain.Department;

public class IncreaseSalaryRequest {
	@NotNull
	private Department department;
	@Positive
	private double rate;

	public IncreaseSalaryRequest() {
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "IncreaseSalaryRequest [department=" + department + ", rate=" + rate + "]";
	}

}
