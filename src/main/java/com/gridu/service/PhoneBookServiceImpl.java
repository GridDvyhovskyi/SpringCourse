package com.gridu.service;

import com.gridu.model.Payload;
import com.gridu.model.Record;
import com.gridu.repository.InMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("phoneBookService")
public class PhoneBookServiceImpl implements PhoneBookService {
    private InMemoryRepository repository;

    @Autowired
    public PhoneBookServiceImpl(InMemoryRepository inMemoryRepository){
        repository = inMemoryRepository;
    }

    /**
     * @return all pairs of type {name: [phone1, phone2]}
     */
    @Override
    public Set<Record> getAllRecords() {
        return repository.findAll();
    }

    @Override
    public void deleteRecordByName(String name)  {
        this.repository.deleteRecordByName(name);
    }

    @Override
    public Set<String> getPhonesByName(String name)  {
        return this.repository.findAllPhonesByName(name);
    }

    @Override
    public Record saveRecord(Payload payload)  {
        return this.updateRecord(payload.getName(), payload.getPhone());
    }

    @Override
    public Record updateRecord(String name, String newPhoneNumber) {
        Record foundRecord = this.repository.findRecordByName(name).orElse(null);
        if (foundRecord!=null){
            foundRecord.addAnotherPhone(newPhoneNumber);
        }
        else {
            foundRecord = new Record(name, Set.of(newPhoneNumber));
            this.repository.addRecord(foundRecord);
        }
        return foundRecord;
    }

}
