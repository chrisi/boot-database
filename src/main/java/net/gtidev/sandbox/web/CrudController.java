package net.gtidev.sandbox.web;

import net.gtidev.sandbox.SyncResult;
import net.gtidev.sandbox.SyncStatus;
import net.gtidev.sandbox.dbaccess.ExtendedJpaRepository;
import net.gtidev.sandbox.model.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;

public class CrudController<T extends Record, ID extends Serializable, R extends ExtendedJpaRepository<T, ID>> {

    @Autowired
    private R repository;

    private static final Logger LOG = LoggerFactory.getLogger(CrudController.class);

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<T> getRecord() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public T getRecord(@PathVariable("id") ID id) {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException((Long) id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateRecord(@PathVariable("id") ID id, @RequestBody T record) {
        validateRecord(id);
        T result;
        try {
            result = repository.save(record);
        } catch (Exception e) {
            throw new RecordNotFoundException(e.getMessage());
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(result.getId()).toUri());
        return new ResponseEntity<>(new SyncResult(result.getId(), SyncStatus.Success), httpHeaders, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createRecord(@RequestBody T record) {
        record.setId(null);
        T result;
        try {
            result = repository.save(record);
        } catch (Exception e) {
            throw new RecordNotFoundException(e.getMessage());
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri());
        return new ResponseEntity<>(new SyncResult(result.getId(), SyncStatus.Success), httpHeaders, HttpStatus.CREATED);
    }

    private T validateRecord(ID id) {
        return this.repository.findById(id).orElseThrow(() -> new RecordNotFoundException((Long) id));
    }
}
