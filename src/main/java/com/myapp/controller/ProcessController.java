package com.myapp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.service.EmployeeService;
import com.myapp.service.so.EmployeeSo;

@Controller
@RequestMapping("/ProcessController")
public class ProcessController {

	private static final Logger logger = Logger.getLogger(HelloController.class);

	@Autowired
	private EmployeeService employeeService;

//	@RequestMapping(value = "{name}", method = RequestMethod.GET)
//	public @ResponseBody EmployeeSo getShopInJSON(@PathVariable String name) {
//
//		EmployeeSo so = new EmployeeSo();
//		so.setEmpName("1");
//		so.setEmpDesc("1");
//		so.setEmpGender("1");
//
//		return so;
//	}

	@RequestMapping(value = "/getData", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EmployeeSo> getAllData(@RequestBody EmployeeSo employeeSo) throws Exception {

		logger.debug("#### Inside getAllData()");

		List<EmployeeSo> empList = employeeService.getData(employeeSo);

		return empList;
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