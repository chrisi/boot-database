package net.gtidev.sandbox.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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
}
