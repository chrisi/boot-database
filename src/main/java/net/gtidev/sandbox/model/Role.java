package net.gtidev.sandbox.model;

import javax.persistence.*;
import java.util.List;

@Entity
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }
}
