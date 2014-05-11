package net.gtidev.sandbox.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"EMP_NO"})
})
@SequenceGenerator(name = "seqGen", sequenceName = "employee_id_seq")
public class Employee extends AuditableRecord<Long> {

  @ManyToOne
  @JoinColumn(name = "DEPARTMENT_ID")
  private Department department;
  @ManyToOne
  @JoinColumn(name = "PERSON_ID")
  private Person person;
  @Column(name = "EMP_NO")
  private Integer empNo;

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Integer getEmpNo() {
    return empNo;
  }

  public void setEmpNo(Integer empNo) {
    this.empNo = empNo;
  }
}
