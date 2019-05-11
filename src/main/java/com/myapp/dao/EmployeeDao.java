package com.myapp.dao;

import java.util.List;

import com.myapp.service.so.EmployeeSo;

public interface EmployeeDao {

	public List<EmployeeSo> getData(EmployeeSo employeeSo) throws Exception;

	public EmployeeSo save(EmployeeSo employeeSo) throws Exception;

}
