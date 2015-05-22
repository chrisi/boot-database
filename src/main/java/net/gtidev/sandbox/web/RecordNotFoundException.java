package net.gtidev.sandbox.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(Long id) {
        super("could not find record with id '" + id + "'.");
    }

    public RecordNotFoundException(String msg) {
        super(msg);
    }
}
