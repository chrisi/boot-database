package net.gtidev.sandbox.dbaccess;

import net.gtidev.sandbox.model.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {
  List<Address> findByStreet(String street);
}
