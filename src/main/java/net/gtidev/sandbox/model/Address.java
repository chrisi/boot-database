package net.gtidev.sandbox.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String street;
  private String zip;
  private String city;

  public Long getId() {
    return id;
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
}
