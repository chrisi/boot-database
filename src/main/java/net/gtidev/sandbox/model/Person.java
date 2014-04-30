package net.gtidev.sandbox.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
@NamedQuery(name = "Person.findByName", query = "select p from Person p where p.lastName = :lastName")
public class Person implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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
