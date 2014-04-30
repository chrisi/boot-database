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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  @ManyToOne
  @JoinColumn(name = "AUTHOR_ID")
  private Person author;
  private String isbn;
  private Date release;

  private Date created;
  private Date modified;

  @PreUpdate
  public void preUpdate() {
    modified = new Date();
  }

  @PrePersist
  public void prePersist() {
    Date now = new Date();
    created = now;
    modified = now;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Person getAuthor() {
    return author;
  }

  public String getIsbn() {
    return isbn;
  }

  public Date getRelease() {
    return release;
  }

  public Date getCreated() {
    return created;
  }

  public Date getModified() {
    return modified;
  }
}
