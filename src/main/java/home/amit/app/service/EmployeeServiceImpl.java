package home.amit.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import home.amit.app.dto.EmployeeDTO;
import home.amit.app.model.Employee;
import home.amit.app.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Cacheable(value="getEmployees")
	public List<EmployeeDTO> getAllEmployees() {

		 Iterable<Employee> employees = employeeRepository.findAll();
		 List<EmployeeDTO> employeesList=new ArrayList<>();
		 employees.forEach(e->{
			 EmployeeDTO dto= new EmployeeDTO();
			 BeanUtils.copyProperties(e, dto);
			 employeesList.add(dto);
		 });
		 
		 return employeesList;
	}

	@Cacheable(value="getEmployees" , key="#id")
	public EmployeeDTO getEmployee(String id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		EmployeeDTO dto = new EmployeeDTO();
		if (employee.isPresent())
		{
			BeanUtils.copyProperties(employee.get(), dto);
			return dto;
		}
		else
		{
			return null;
		}
	}

	@CachePut(value="getEmployees")
	public Employee updateEmployee(EmployeeDTO updatedDTO) {

		Employee emp=new Employee();
		BeanUtils.copyProperties(updatedDTO, emp);
		Employee insertedEmp = employeeRepository.save(emp);
		return insertedEmp;
	}

	@CacheEvict(value="getEmployees")
	public void deleteEmployee(String empId) {
		employeeRepository.deleteById(empId);
	}

	@CachePut(value="getEmployees")
	@Override
	public Employee createEmployee(EmployeeDTO empDTO) {
		Employee emp=new Employee();
		BeanUtils.copyProperties(empDTO, emp);
		Employee insertedEmp = employeeRepository.save(emp);
		return insertedEmp;
	}

}
