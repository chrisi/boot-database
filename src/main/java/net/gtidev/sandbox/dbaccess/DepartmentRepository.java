package net.gtidev.sandbox.dbaccess;

import net.gtidev.sandbox.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
