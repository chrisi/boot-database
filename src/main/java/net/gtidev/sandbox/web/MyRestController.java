package net.gtidev.sandbox.web;

import net.gtidev.sandbox.dbaccess.AddressRepository;
import net.gtidev.sandbox.dbaccess.PersonFlatRepository;
import net.gtidev.sandbox.model.Address;
import net.gtidev.sandbox.model.PersonFlat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class MyRestController {

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private PersonFlatRepository personFlatRepository;

  private static final Logger LOG = LoggerFactory.getLogger(MyRestController.class);

  @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
  public Address getAddress(@PathVariable("id") Long id) {
    LOG.info("GET /address/{}", id);
    return addressRepository.findOne(id);
  }

  @RequestMapping(value = "/address/{id}", method = RequestMethod.POST)
  public ResponseEntity<?> postAddress(@PathVariable("id") Long id, @RequestBody Address address) {
    LOG.info("POST /address/{} ({})", id, address);
    Address result = addressRepository.save(address);

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri());
    return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/address", method = RequestMethod.POST)
  public String postAddress(@RequestBody Address address) {
    LOG.info("POST /address/{} ({})", address.getId(), address);
    Address result = addressRepository.save(address);

    return "success";
  }

  @RequestMapping(value = "/address", method = RequestMethod.GET)
  public Iterable<Address> getAddresses() {
    LOG.info("GET /address");
    return addressRepository.findAll();
  }

  @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
  public PersonFlat getPerson(@PathVariable("id") Long id) {
    LOG.info("GET /person/{}", id);
    return personFlatRepository.findOne(id);
  }

  private void validateAddress(Long id) {
    this.addressRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
  }
}
