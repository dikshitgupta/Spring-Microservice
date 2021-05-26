package com.nagal.department.controller;

import com.nagal.department.entity.Department;
import com.nagal.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department){
		log.info("inside Savedepartment method in controller");
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable("id") Long departmentId){
		log.info("inside department method in controller");
		return departmentService.getDepartmentById(departmentId);
	}

}
