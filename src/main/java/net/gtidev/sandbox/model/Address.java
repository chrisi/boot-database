package net.gtidev.sandbox.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq_gen")
  @SequenceGenerator(name = "address_seq_gen", sequenceName = "address_id_seq")
  private Long id;

  private String street;
  private String zip;
  private String city;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String toSQL() {
    return "insert into ADDRESS (id,street,zip,city) values ({id},'{street}','{zip}','{city}');"
        .replace("{id}", id.toString())
        .replace("{street}", street)
        .replace("{zip}", zip)
        .replace("{city}", city);
  }
}
