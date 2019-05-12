package home.amit.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import home.amit.app.dto.EmployeeDTO;
import home.amit.app.service.EmployeeService;

@RestController
public class EmployeeRestServiceController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String getName()
	{
		return "Hello World";
	}
	

	@GetMapping("/getAllEmployees")
	public List<EmployeeDTO> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	
}
