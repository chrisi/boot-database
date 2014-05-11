package net.gtidev.sandbox.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DEPARTMENT")
@SequenceGenerator(name = "seqGen", sequenceName = "department_id_seq")
public class Department extends AuditableRecord<Long> {

  private String ident;
  private String name;

  @OneToMany(mappedBy = "department")
  private List<Employee> employees;
  @ManyToOne
  @JoinColumn(name = "MANAGER_ID")
  private Employee manager;

  public String getIdent() {
    return ident;
  }

  public void setIdent(String ident) {
    this.ident = ident;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  public Employee getManager() {
    return manager;
  }

  public void setManager(Employee manager) {
    this.manager = manager;
  }
}
