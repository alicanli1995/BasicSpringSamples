package com.example.hr.infra;

import com.example.hr.application.business.event.EmployeeEvent;

public interface EventPublisher {

	void publish(EmployeeEvent employeeEvent);

}
