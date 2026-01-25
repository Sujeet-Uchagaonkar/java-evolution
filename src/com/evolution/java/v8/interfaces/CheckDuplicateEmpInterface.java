package com.evolution.java.v8.interfaces;

import com.evolution.java.v8.entity.Employee;

@FunctionalInterface
public interface CheckDuplicateEmpInterface {

	Boolean isDuplicateEmp(Employee e1, Employee e2);
	
}
