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
  @JsonDeserialize(using = MyDateDeserializer.class)
  @JsonSerialize(using = MyDateSerializer.class)
  private Date release;
  @JsonDeserialize(using = MyDateDeserializer.class)
  @JsonSerialize(using = MyDateSerializer.class)
  private Date created;
  @JsonDeserialize(using = MyDateDeserializer.class)
  @JsonSerialize(using = MyDateSerializer.class)
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

  public String toSQL() {
    return "insert into BOOK (id,name,author_id,release) values ({id},'{name}',{author_id},'{release}');"
        .replace("{id}", id.toString())
        .replace("{name}", name)
        .replace("{author_id}", author.getId().toString())
        .replace("{release}", release.toString());
  }
}
