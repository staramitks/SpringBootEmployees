package home.amit.app.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import home.amit.app.model.Employee;

@Repository("employeeRepository")
public interface EmployeeRepository extends CrudRepository<Employee, String> {
}
