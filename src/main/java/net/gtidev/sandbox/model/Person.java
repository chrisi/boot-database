package net.gtidev.sandbox.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import net.gtidev.sandbox.MyDateDeserializer;
import net.gtidev.sandbox.MyDateSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "PERSON")
@NamedQuery(name = "Person.findByName", query = "select p from Person p where p.lastName = :lastName")
public class Person implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq_gen")
  @SequenceGenerator(name = "person_seq_gen", sequenceName = "person_id_seq")
  private Long id;

  private String firstName;
  private String lastName;
  @JsonDeserialize(using = MyDateDeserializer.class)
  @JsonSerialize(using = MyDateSerializer.class)
  private Date birthDate;
  @ManyToOne
  @JoinColumn(name = "ADDRESS_ID")
  private Address address;
}
