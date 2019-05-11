package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.EmployeeDao;
import com.myapp.service.so.EmployeeSo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<EmployeeSo> getData(EmployeeSo employeeSo) throws Exception {

		return employeeDao.getData(employeeSo);
	}

	@Override
	@Transactional
	public EmployeeSo save(EmployeeSo employeeSo) throws Exception {

		return employeeDao.save(employeeSo);
	}

}
