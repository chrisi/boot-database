package net.gtidev.sandbox.web;

import net.gtidev.sandbox.SyncResult;
import net.gtidev.sandbox.SyncStatus;
import net.gtidev.sandbox.dbaccess.AddressRepository;
import net.gtidev.sandbox.model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    private static final Logger LOG = LoggerFactory.getLogger(AddressController.class);

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Address> getAddresses() {
        LOG.info("GET /address");
        return addressRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Address getAddress(@PathVariable("id") Long id) {
        LOG.info("GET /address/{}", id);
        return addressRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAddress(@PathVariable("id") Long id, @RequestBody Address address) {
        LOG.info("PUT /address/{} ({})", id, address);
        validateAddress(id);
        Address result = addressRepository.save(address);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(result.getId()).toUri());
        return new ResponseEntity<>(new SyncResult(result.getId(), SyncStatus.Success), httpHeaders, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createAddress(@RequestBody Address address) {
        LOG.info("POST /address", address);
        address.setId(null);
        Address result = addressRepository.save(address);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri());
        return new ResponseEntity<>(new SyncResult(result.getId(), SyncStatus.Success), httpHeaders, HttpStatus.CREATED);
    }

    private Address validateAddress(Long id) {
        return this.addressRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }
}
