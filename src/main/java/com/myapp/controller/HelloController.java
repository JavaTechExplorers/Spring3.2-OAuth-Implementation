package com.myapp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.service.EmployeeService;
import com.myapp.service.so.EmployeeSo;

@Controller
public class HelloController {

	private static final Logger logger = Logger.getLogger(HelloController.class);

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		logger.debug("#### Inside welcomePage()");
		ModelAndView model = new ModelAndView();
		model.setViewName("index");

		return model;
	}

	@RequestMapping(value = "/userHome", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		logger.debug("#### Inside adminPage()");

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security");
		model.addObject("message", "You have logged in successfully");

		model.setViewName("home");

		System.out.println("##################### Checking Embedded Database Conn ##################");
		try {
			List<EmployeeSo> empList = employeeService.getData(null);
			for (EmployeeSo employeeSo : empList) {

				System.out.println("Emp Name = " + employeeSo.getEmpName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;
	}

	// Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		logger.debug("#### Inside login()");

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;
	}

}