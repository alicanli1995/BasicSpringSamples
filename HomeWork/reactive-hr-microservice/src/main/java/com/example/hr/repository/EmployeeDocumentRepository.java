package com.example.hr.repository;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.domain.Department;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface EmployeeDocumentRepository extends ReactiveMongoRepository<EmployeeDocument, String> {
	Flux<EmployeeDocument> findAllByDepartment(Department department);
}
