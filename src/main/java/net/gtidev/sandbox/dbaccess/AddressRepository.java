package net.gtidev.sandbox.dbaccess;

import net.gtidev.sandbox.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
  List<Address> findByStreet(String street);

  Optional<Address> findById(Long id);
}
