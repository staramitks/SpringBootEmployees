package home.amit.app.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.amit.app.dto.EmployeeDTO;
import home.amit.app.model.Employee;
import home.amit.app.service.EmployeeService;

@RestController
@RequestMapping({ "/employees" })
public class EmployeeRestServiceController {

	private static Logger LOG=Logger.getLogger(EmployeeRestServiceController.class.getName());
	
	@Autowired
	private EmployeeService employeeService;
	
//	private List<EmployeeDTO> employees = getAllEmployees();
	
	@GetMapping("/")
	public String getName()
	{
		return "Hello World";
	}
	

	@GetMapping("/getAllEmployees")
	public List<EmployeeDTO> getAllEmployees()
	{
		LOG.info("Calling Get Employees");
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody EmployeeDTO empDTO)
	{
		return employeeService.createEmployee(empDTO);
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody EmployeeDTO empDTO)
	{
		return employeeService.updateEmployee(empDTO);
	}
	
	@DeleteMapping(path = { "/{id}" })
	public void deleteEmployee(@PathVariable("id") String empId)
	{
		 employeeService.deleteEmployee(empId);
	}
	
}
