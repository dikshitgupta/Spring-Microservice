package com.nagal.department.service;

import com.nagal.department.entity.Department;
import com.nagal.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public Department getDepartmentById(Long departmentId) {
		return departmentRepository.getByDepartmentId(departmentId);
	}
}
