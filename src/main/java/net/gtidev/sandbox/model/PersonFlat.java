package net.gtidev.sandbox.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import net.gtidev.sandbox.MyDateDeserializer;
import net.gtidev.sandbox.MyDateSerializer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "PERSON")
public class PersonFlat implements Serializable {

  @Id
  private Long id;

  private String firstName;
  private String lastName;
  @JsonDeserialize(using = MyDateDeserializer.class)
  @JsonSerialize(using = MyDateSerializer.class)
  private Date birthDate;
  @Column(name = "ADDRESS_ID")
  private Long addressId;
}