package net.gtidev.sandbox.dbaccess;

import net.gtidev.sandbox.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
