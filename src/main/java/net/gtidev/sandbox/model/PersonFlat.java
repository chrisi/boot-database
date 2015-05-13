package net.gtidev.sandbox.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PERSON")
public class PersonFlat implements Serializable {

    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private Date birthDate;
    @Column(name = "ADDRESS_ID")
    private Long addressId;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Long getAddressId() {
        return addressId;
    }
}