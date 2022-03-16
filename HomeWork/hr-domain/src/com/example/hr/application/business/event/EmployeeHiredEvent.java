package com.example.hr.application.business.event;

import com.example.hr.domain.IdentityNo;

public class EmployeeHiredEvent extends EmployeeEvent {

	public EmployeeHiredEvent(IdentityNo identity) {
		super(identity);
	}
	
}
