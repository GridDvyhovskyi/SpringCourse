package com.gridu.controller;

import com.gridu.exception.InvalidArgumentException;
import com.gridu.exception.ResourceNotFoundException;
import com.gridu.model.Payload;
import com.gridu.model.Record;
import com.gridu.service.PhoneBookService;
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
    private PhoneBookService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/records",
            produces = "application/json")
    public Set<Record> listOfAllRecords() {
        return service.getAllRecords();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="/records")
    public Record createNewRecord(@RequestBody Payload payload)  throws InvalidArgumentException {
        if (payload==null){
            throw new InvalidArgumentException();
        }
        return service.saveRecord(payload);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/records/{name}")
    public Set<String> findPhonesByName(@PathVariable String name) throws ResourceNotFoundException {
        return service.getPhonesByName(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping ("/records/{name}")
    public void deleteRecord(@PathVariable String name) throws ResourceNotFoundException {
        service.deleteRecordByName(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value="/records/{name}")
    public Record updateRecord(@PathVariable String name, @RequestParam String phone) {
        return service.updateRecord(name, phone);
    }

}
