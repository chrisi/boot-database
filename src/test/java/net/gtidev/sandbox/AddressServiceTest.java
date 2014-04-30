package net.gtidev.sandbox;

import net.gtidev.sandbox.dbaccess.AddressRepository;
import net.gtidev.sandbox.model.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class AddressServiceTest {

  @Autowired
  private AddressRepository repo;

  @Test
  public void testAddressServiceLoad() {

    List<Address> lst = repo.findByLastName("Gebauer");

    Address adr = repo.findOne(1L);

    int i = 0;

  }
}
