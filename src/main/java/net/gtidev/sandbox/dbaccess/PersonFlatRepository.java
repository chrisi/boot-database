package net.gtidev.sandbox.dbaccess;

import net.gtidev.sandbox.model.PersonFlat;
import org.springframework.data.repository.CrudRepository;

public interface PersonFlatRepository extends CrudRepository<PersonFlat, Long> {
}
