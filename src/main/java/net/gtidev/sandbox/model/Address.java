package net.gtidev.sandbox.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ADDRESS")
public class Address implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq_gen")
  @SequenceGenerator(name = "address_seq_gen", sequenceName = "address_id_seq")
  private Long id;

  private String street;
  private String zip;
  private String city;

  public String toSQL() {
    return "insert into ADDRESS (id,street,zip,city) values ({id},'{street}','{zip}','{city}');"
        .replace("{id}", id.toString())
        .replace("{street}", street)
        .replace("{zip}", zip)
        .replace("{city}", city);
  }
}
