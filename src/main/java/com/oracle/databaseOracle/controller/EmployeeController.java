package com.oracle.databaseOracle.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.oracle.databaseOracle.Error.DataNotFoundException;
import com.oracle.databaseOracle.entity.Emp;
import com.oracle.databaseOracle.entity.Employees;
import com.oracle.databaseOracle.entity.ErrorMessage;
import com.oracle.databaseOracle.entity.e;
import com.oracle.databaseOracle.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ErrorMessage errorMessage;
	
	
	public static final Logger  log = LoggerFactory.getLogger(EmployeeController.class);

	
	@GetMapping("/getAll")
	public ModelAndView thyGetAllEmployee() {
		ModelAndView mav = new ModelAndView("getAllEmp");
		List<Employees> emp = employeeService.getAllEmployees();
	    mav.addObject("e", emp);
		return mav;
	}
	
	@GetMapping("/")
	public ModelAndView homePage() {
		ModelAndView mav1 = new ModelAndView("home");
		List<Emp> emp1 = employeeService.getAllEmployee();
	    mav1.addObject("emp", emp1);
		return mav1;
	}
	
	@GetMapping("/addEmployee")
	public ModelAndView addEmployee() {
		ModelAndView mav = new ModelAndView("newEmployee");
		Emp emp = new Emp();
		mav.addObject("emp", emp);
		return mav;
	}
	@PostMapping("/saveEmployee")
	public ModelAndView saveEmployee(@ModelAttribute("emp") Emp emp) {
		employeeService.saveEmployee(emp);
		return homePage();
	}
	
	@GetMapping("/getdeleteEmployeeId")
	public ModelAndView getdeleteEmployeeId() {
		ModelAndView mav = new ModelAndView("deleteEmp");
		Emp emp = new Emp();
		mav.addObject("emp", emp);
		return mav;
	}
	
	@PostMapping("/deleteEmployee")
	public ModelAndView deleteEmployee(@ModelAttribute("emp") Emp emp) {
		try {
			employeeService.deleteEmployee(emp.EMPLOYEE_ID);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return homePage();
	}
	
	@GetMapping("/getIdUpdateEmployee")
	public ModelAndView getIdUpdateEmployee() {
		ModelAndView mav = new ModelAndView("updateEmp");
		Emp emp = new Emp();
		mav.addObject("emp", emp);
		return mav;
	}
	
	@PostMapping("/updateEmployee")
	public ModelAndView updateEmployee(@ModelAttribute("emp") Emp emp) {
		ModelAndView mav = new ModelAndView("updateEmpForm");
		Emp emp2 = employeeService.getEmployeeById(emp.EMPLOYEE_ID);
		mav.addObject("emp",emp2);
		return mav;
	}
	
	@PostMapping("/doUpdate")
	public ModelAndView doUpdate(@ModelAttribute("emp") Emp emp) {
		employeeService.updateById(emp);
		return homePage();
	}

	@PutMapping("/save")
	public ResponseEntity<Object> saveEmployee(@RequestBody Employees employees) {
		try {
			Employees emp = employeeService.saveEmployee(employees);
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") long employeeId) throws DataNotFoundException {
		try {
			employeeService.deleteEmployeeOld(employeeId);
			return new ResponseEntity<>("Record deleted", HttpStatus.OK);

		} catch (Exception e) {
			errorMessage.setHttpStatus(HttpStatus.NOT_FOUND);
			errorMessage.setMessage(e.getMessage());
			return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/update/{id}/{firstName}")
	public ResponseEntity<Object> updateEmployee(@PathVariable("id") long employeeId,
			@PathVariable("firstName") String firstName) throws DataNotFoundException {
		try {
			Object object = employeeService.updateEmployee(employeeId, firstName);
			return new ResponseEntity<>(object, HttpStatus.OK);

		} catch (Exception e) {
			errorMessage.setHttpStatus(HttpStatus.NOT_FOUND);
			errorMessage.setMessage(e.getMessage());
			return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/get/salary/{salary}")
	public int getCountOfEmployeesBasedOnSalary(@PathVariable("salary") long salary) {
		return employeeService.getCountOfEmployeesBasedOnSalary(salary);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public int getCountOfEmployes() {
		return employeeService.getCountOfEmployes();
	}

	@GetMapping("/NgetAll")
	public List<Employees> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	

	
	@GetMapping("/wel/{name}")
	public ModelAndView thyWelcome(@PathVariable("name") String name) {
		ModelAndView mav = new ModelAndView("welcome");
		mav.addObject("name", name);
		return mav;
	}

	@GetMapping("/get/{id}")
	public List<e> getTop3EmployeesBasedOnSalary(@PathVariable("id") String department_id) {
		return employeeService.getTop3EmployeesBasedOnSalary(department_id);
	}

	@Value("${welcome.message}")
	private String msg;

	@GetMapping("/greet")
	public String greet() {
		return msg;
	}
}
