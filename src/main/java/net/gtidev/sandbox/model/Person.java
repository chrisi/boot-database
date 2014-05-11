package net.gtidev.sandbox.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PERSON")
@NamedQuery(name = "Person.findByName", query = "select p from Person p where p.lastName = :lastName")
public class Person implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq_gen")
  @SequenceGenerator(name = "person_seq_gen", sequenceName = "person_id_seq")
  private Long id;

  private String firstName;
  private String lastName;
  private Date birthDate;
  @ManyToOne
  @JoinColumn(name = "ADDRESS_ID")
  private Address address;

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public Address getAddress() {
    return address;
  }
}
