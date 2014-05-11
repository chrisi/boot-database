package net.gtidev.sandbox.dbaccess;

import net.gtidev.sandbox.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
