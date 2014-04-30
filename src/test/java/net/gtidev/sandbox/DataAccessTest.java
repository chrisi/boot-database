package net.gtidev.sandbox;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import junit.framework.Assert;
import net.gtidev.sandbox.dbaccess.BookService;
import net.gtidev.sandbox.dbaccess.PersonRepository;
import net.gtidev.sandbox.model.Book;
import net.gtidev.sandbox.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class DataAccessTest {

  @Autowired
  private PersonRepository repo;

  @Autowired
  private BookService bookService;

  @PersistenceContext
  private EntityManager em;

  @Test
  public void testPersonCrudRepository() {
    Person per = repo.findOne(1L);
    Assert.assertEquals("Gebauer", per.getLastName());
    List<Person> lst = repo.findByLastName("Gebauer");
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
}
