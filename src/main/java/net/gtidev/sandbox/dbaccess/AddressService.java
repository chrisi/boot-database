package net.gtidev.sandbox.dbaccess;

import net.gtidev.sandbox.model.Address;

public interface AddressService {
  Address loadAddress(Long id);
}
