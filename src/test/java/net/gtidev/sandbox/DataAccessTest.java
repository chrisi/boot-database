package net.gtidev.sandbox;

import junit.framework.Assert;
import net.gtidev.sandbox.dbaccess.AddressRepository;
import net.gtidev.sandbox.dbaccess.BookService;
import net.gtidev.sandbox.dbaccess.PersonRepository;
import net.gtidev.sandbox.model.Address;
import net.gtidev.sandbox.model.Book;
import net.gtidev.sandbox.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class}, initializers = ConfigFileApplicationContextInitializer.class)
public class DataAccessTest {

  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private BookService bookService;

  @PersistenceContext
  private EntityManager em;


  @Test
  public void testPersonCrudRepository() {
    Person per = personRepository.findOne(1L);
    Assert.assertEquals("Gebauer", per.getLastName());
    List<Person> lst = personRepository.findByLastName("Gebauer");
    Assert.assertEquals(1, lst.size());
  }

  @Test
  public void testPersonNamedQuery() {
    Person per = em.createNamedQuery("Person.findByName", Person.class).setParameter("lastName", "Gebauer").getSingleResult();
    Assert.assertEquals("Gebauer", per.getLastName());
  }

  @Test
  public void testBookServiceLoad() {
    Book bk = bookService.loadBook(1L);
    Assert.assertEquals("Spring Boot in Action", bk.getName());
  }

  @Test
  public void testExport() {
    Iterable<Address> lst = addressRepository.findAll();
    for (Address adr : lst) {
      System.err.println(adr.toSQL());
    }
  }

  @Test
  public void testInsertAddress() {
    Address adr = new Address();
    adr.setStreet("Nieuwpoorter Str. 99");
    adr.setZip("63110");
    adr.setCity("Rodgau");
    addressRepository.save(adr);
  }

  @Test
  public void testDeleteAddress() {
    List<Address> lst = addressRepository.findByStreet("Nieuwpoorter Str. 99");
    Assert.assertEquals(1, lst.size());
    addressRepository.delete(lst.get(0));
    lst = addressRepository.findByStreet("Nieuwpoorter Str. 99");
    Assert.assertEquals(0, lst.size());
  }

  @Test
  public void testPersonSubRecord() {
    List<Person> lst = personRepository.findByLastName("Gebauer");
    Assert.assertEquals(1, lst.size());


  }

}
