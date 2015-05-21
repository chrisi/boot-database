package net.gtidev.sandbox.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {

  public RecordNotFoundException(Long userId) {
    super("could not find record with id '" + userId + "'.");
  }
}
