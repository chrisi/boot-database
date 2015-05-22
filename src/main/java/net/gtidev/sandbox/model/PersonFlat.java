package net.gtidev.sandbox.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import net.gtidev.sandbox.MyDateDeserializer;
import net.gtidev.sandbox.MyDateSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "PERSON")
@SequenceGenerator(name = "seqGen", sequenceName = "person_id_seq")
public class PersonFlat extends Record<Long> {

  private String firstName;
  private String lastName;
  @JsonDeserialize(using = MyDateDeserializer.class)
  @JsonSerialize(using = MyDateSerializer.class)
  private Date birthDate;
  @Column(name = "ADDRESS_ID")
  private Long addressId;
}