package net.gtidev.sandbox.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ADDRESS")
@SequenceGenerator(name = "seqGen", sequenceName = "address_id_seq")
public class Address extends Record<Long> {

    private String street;
    private String zip;
    private String city;

    public String toSQL() {
        return "insert into ADDRESS (id,street,zip,city) values ({id},'{street}','{zip}','{city}');"
                .replace("{id}", getId().toString())
                .replace("{street}", street)
                .replace("{zip}", zip)
                .replace("{city}", city);
    }
}
