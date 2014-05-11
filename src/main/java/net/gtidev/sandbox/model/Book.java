package net.gtidev.sandbox.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "BOOK")
public class Book implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq_gen")
  @SequenceGenerator(name = "author_seq_gen", sequenceName = "author_id_seq")
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



  public String toSQL() {
    return "insert into BOOK (id,name,author_id,release) values ({id},'{name}',{author_id},'{release}');"
        .replace("{id}", id.toString())
        .replace("{name}", name)
        .replace("{author_id}", author.getId().toString())
        .replace("{release}", release.toString());
  }
}
