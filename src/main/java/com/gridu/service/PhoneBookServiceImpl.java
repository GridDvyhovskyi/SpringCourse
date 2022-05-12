package com.gridu.service;

import com.gridu.exception.InvalidArgumentException;
import com.gridu.exception.ResourceNotFoundException;
import com.gridu.model.Payload;
import com.gridu.model.Record;
import com.gridu.repository.InMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("phoneBookService")
public class PhoneBookServiceImpl implements PhoneBookService {
    @Autowired
    private InMemoryRepository repository;

    public PhoneBookServiceImpl(InMemoryRepository inMemoryRepository){
        repository = inMemoryRepository;
    }

    /**
     * injection is supported on setter level
     *
     * @param repository
     */
    @Override
    public void setRepository(InMemoryRepository repository) {
        this.repository = repository;
    }

    /**
     * @return all pairs of type {name: [phone1, phone2]}
     */
    @Override
    public Set<Record> getAllRecords() {
        return repository.findAll();
    }

    @Override
    public void deleteRecordByName(String name) throws ResourceNotFoundException {
        Record record = this.repository.findRecordByName(name).
                orElseThrow(() -> new ResourceNotFoundException("Name", name));
        this.repository.deleteRecordByName(record.getName());
    }

    @Override
    public Set<String> getPhonesByName(String name) throws ResourceNotFoundException {
        return this.repository.findAllPhonesByName(name);
    }

    @Override
    public Record saveRecord(Payload payload) throws InvalidArgumentException {
        try {
            Record newRecord =
                    new Record(payload.getName(), Set.of(payload.getPhone()));
            return this.repository.addRecord(newRecord);
        }
        catch (Exception ex){
            throw new InvalidArgumentException();
        }
    }

    @Override
    public Record updateRecord(String name, String newPhoneNumber) {
        Record foundRecord = this.repository.findRecordByName(name).orElse(null);
        if (foundRecord!=null){
            Set<String> newPhones = new HashSet<>(foundRecord.getPhoneNumbers());
            newPhones.add(newPhoneNumber);
            foundRecord.setPhoneNumbers(newPhones);
        }
        else {
            foundRecord = new Record(name, Set.of(newPhoneNumber));
        }
        return foundRecord;
    }


}
