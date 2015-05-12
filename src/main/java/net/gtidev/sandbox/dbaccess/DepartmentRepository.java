package net.gtidev.sandbox.dbaccess;

import net.gtidev.sandbox.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

  int var1 = 0;
  int var2 = 0;


}
