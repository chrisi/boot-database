package net.gtidev.sandbox.model;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

public class AuditableRecord<T extends Serializable> extends Record<T> {

  private Date created;
  private Date modified;

  public Date getCreated() {
    return created;
  }

  public Date getModified() {
    return modified;
  }

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
}
