package in.cdac.repo;

import org.springframework.data.repository.CrudRepository;

import in.cdac.db.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}