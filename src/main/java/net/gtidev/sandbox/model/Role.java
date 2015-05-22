package net.gtidev.sandbox.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "ROLE")
@SequenceGenerator(name = "seqGen", sequenceName = "role_id_seq")
public class Role extends Record<Long> {

  private String name;
  private String description;

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(name = "ROLE_ROLE",
      joinColumns = {@JoinColumn(name = "ROLE_ID")},
      inverseJoinColumns = {@JoinColumn(name = "CHILDROLE_ID")})
  private List<Role> roles;
}
