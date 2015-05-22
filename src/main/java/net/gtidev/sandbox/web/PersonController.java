package net.gtidev.sandbox.web;

import net.gtidev.sandbox.dbaccess.PersonFlatRepository;
import net.gtidev.sandbox.model.PersonFlat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController extends CrudController<PersonFlat, Long, PersonFlatRepository> {

}