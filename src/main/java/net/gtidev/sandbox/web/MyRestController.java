package net.gtidev.sandbox.web;

import net.gtidev.sandbox.dbaccess.AddressRepository;
import net.gtidev.sandbox.dbaccess.PersonFlatRepository;
import net.gtidev.sandbox.model.Address;
import net.gtidev.sandbox.model.Person;
import net.gtidev.sandbox.model.PersonFlat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonFlatRepository personFlatRepository;

    @RequestMapping("/address/{id}")
    public Address getAddress(@PathVariable("id") Long id) {
        return addressRepository.findOne(id);
    }

    @RequestMapping("/address")
    public Iterable<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @RequestMapping("/person/{id}")
    public PersonFlat getPerson(@PathVariable("id") Long id) {
        return personFlatRepository.findOne(id);
    }

}
