package com.example.hr.application.business.event;

import com.example.hr.domain.Employee;

public class EmployeeFiredEvent extends EmployeeEvent {

	private final Employee employee;

	public EmployeeFiredEvent(Employee employee) {
		super(employee.getIdentity());
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

}
