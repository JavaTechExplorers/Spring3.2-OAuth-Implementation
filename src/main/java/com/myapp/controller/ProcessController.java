package com.myapp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.service.EmployeeService;
import com.myapp.service.so.EmployeeSo;
import com.myapp.service.so.UserSo;

@Controller
@RequestMapping("/ProcessController")
public class ProcessController {

	private static int flipValue = 0;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

	@RequestMapping(value = "/getData", method = RequestMethod.POST)
	public @ResponseBody List<EmployeeSo> getAllData(@RequestBody EmployeeSo employeeSo) throws Exception {

		List<EmployeeSo> empList = employeeService.getData(employeeSo);

		return empList;
	}

	@RequestMapping(value = "/getMultiData", method = RequestMethod.POST)
	public @ResponseBody Object getMultiData(@RequestBody EmployeeSo employeeSo) throws Exception {

		if (flipValue == 0) {
			flipValue = 1;

			EmployeeSo emp = new EmployeeSo();
			emp.setEmpName("Vignesh");
			emp.setEmpGender("Male");
			emp.setEmpDesc("Good Emp");

			return emp;
		} else {
			flipValue = 0;

			UserSo user = new UserSo();
			user.setUsername("admin");
			user.setPassword("admin");

			return user;

		}
		// List<EmployeeSo> empList = employeeService.getData(employeeSo);
		// return null;
		// return empList.get(0);
	}

	// @RequestMapping(value = "/save", method = RequestMethod.POST)
	// public ResponseEntity<EmployeeSo> saveData(@RequestBody EmployeeSo
	// employeeSo) throws Exception {
	//
	// employeeService.save(employeeSo);
	//
	// return new ResponseEntity<EmployeeSo>(employeeSo, HttpStatus.OK);
	// }

}