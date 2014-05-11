package net.gtidev.sandbox;

import junit.framework.Assert;
import net.gtidev.sandbox.dbaccess.DepartmentRepository;
import net.gtidev.sandbox.dbaccess.EmployeeRepository;
import net.gtidev.sandbox.dbaccess.PersonRepository;
import net.gtidev.sandbox.dbaccess.RoleRepository;
import net.gtidev.sandbox.model.Department;
import net.gtidev.sandbox.model.Employee;
import net.gtidev.sandbox.model.Person;
import net.gtidev.sandbox.model.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class}, initializers = ConfigFileApplicationContextInitializer.class)
public class OfficeDataAccessTest {

  @Autowired
  private DepartmentRepository deptRepository;

  @Autowired
  private EmployeeRepository empRepository;

  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private RoleRepository roleRepository;

  @PersistenceContext
  private EntityManager em;

//  @Test
//  public void testAddDepartment() {
//    Department dept = new Department();
//    dept.setName("JX IE CPS Customer Portal Services");
//
//    deptRepository.save(dept);
//  }
//
//  @Test
//  public void testAddEmployee() {
//
//    Person pers = personRepository.findOne(1L);
//
//    Employee emp = new Employee();
//    emp.setEmpNo(4711);
//    emp.setPerson(pers);
//
//    empRepository.save(emp);
//  }

  @Test
  public void testOffice() {

    Department dept = new Department();
    dept.setName("JX IE CPS Customer Portal Services");

    deptRepository.save(dept);

    Person pers = personRepository.findOne(1L);

    Employee emp = new Employee();
    emp.setEmpNo(4711);
    emp.setPerson(pers);
    emp.setDepartment(dept);

    Employee persistEmp = empRepository.save(emp);
  }

  @Test
  @Transactional
  public void testRoles() {
    Role role = roleRepository.findOne(1L);

    Assert.assertEquals(2, role.getRoles().size());
  }

  @Test
  @Transactional
  public void testRolesMove() {

    Role atlasUser = roleRepository.findOne(7L);
    Role admin = roleRepository.findOne(1L);

    dumpRoles(admin, 0);

    Role user = roleRepository.findOne(2L);
    user.getRoles().remove(atlasUser);
    admin.getRoles().add(atlasUser);

    roleRepository.save(user);
    roleRepository.save(admin);

    admin = roleRepository.findOne(1L);

    dumpRoles(admin, 0);
  }

  private void dumpRoles(Role role, int indent) {
    System.err.println(spc(indent * 2) + role.getName());
    for (Role sr : role.getRoles()) {
      dumpRoles(sr, indent + 2);
    }
  }

  private String spc(int i) {
    StringBuilder b = new StringBuilder();
    for (int n = 0; n < i; n++)
      b.append(" ");
    return b.toString();
  }

}
