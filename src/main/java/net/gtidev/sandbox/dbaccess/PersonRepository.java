package net.gtidev.sandbox.dbaccess;

import java.util.List;

import net.gtidev.sandbox.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
  List<Person> findByLastName(String lastName);
}
