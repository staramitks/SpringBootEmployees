package home.amit.app.service;

import java.util.List;

import home.amit.app.dto.EmployeeDTO;
import home.amit.app.model.Employee;

public interface EmployeeService {
	
	public List<EmployeeDTO> getAllEmployees();
	public EmployeeDTO getEmployee(String id);
	public Employee createEmployee(EmployeeDTO empDTO);
	public Employee updateEmployee(EmployeeDTO updatedDTO);
	public void deleteEmployee(String empId);
	

}
