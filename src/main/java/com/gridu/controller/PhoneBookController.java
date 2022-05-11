package com.gridu.controller;

import com.gridu.exception.ResourceNotFoundException;
import com.gridu.model.Record;
import com.gridu.repository.InMemoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController()
@RequestMapping(value="/phonebook/api/v1", produces="application/json")
public class PhoneBookController {

    private static final Logger LOG = LoggerFactory.getLogger(PhoneBookController.class);
    @Autowired
    private InMemoryRepository repository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/records/",
            produces = "application/json")
    public Set<Record> listOfAllRecords() {
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="/records")
    public Record createNewRecord(@RequestParam String name,
                                  @RequestParam String phone)  {
            return repository.addPhone(name, phone);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/records/{name}")
    public Set<String> findPhonesByName(@PathVariable String name) throws ResourceNotFoundException {
        return repository.findAllPhonesByName(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping ("/records/{name}")
    public void deleteRecord(@PathVariable String name) throws ResourceNotFoundException {
        repository.deleteRecordByName(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value="/records/{name}")
    public Record updateRecord(@PathVariable String name, @RequestParam String newPhoneNumber) {
        return repository.addPhone(name, newPhoneNumber);
    }

}
