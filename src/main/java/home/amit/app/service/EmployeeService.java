package home.amit.app.service;

import java.util.List;

import home.amit.app.dto.EmployeeDTO;

public interface EmployeeService {
	
	public List<EmployeeDTO> getAllEmployees();
	public EmployeeDTO getEmployee(String id);
	public int updateEmployee(EmployeeDTO updatedDTO);
	public void deleteEmployee(String empId);
	

}
