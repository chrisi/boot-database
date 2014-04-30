package net.gtidev.sandbox.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String firstName;
  private String lastName;
  private String street;
  private String zip;
  private String city;

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getStreet() {
    return street;
  }

  public String getZip() {
    return zip;
  }

  public String getCity() {
    return city;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
