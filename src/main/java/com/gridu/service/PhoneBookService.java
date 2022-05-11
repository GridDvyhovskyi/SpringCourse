package com.gridu.service;

import com.gridu.exception.ResourceNotFoundException;
import com.gridu.model.Record;
import com.gridu.repository.InMemoryRepository;

import java.util.List;
import java.util.Set;

public interface PhoneBookService {
    void setRepository(InMemoryRepository repository);

    List<Record> getAllRecords();

    void add(Record newRecord);

    Record updatePhones(String name, String phone);

    void deleteRecordByName(String name) throws ResourceNotFoundException;

    Set<String> getPhonesByName(String name) throws ResourceNotFoundException;

    Record saveRecord(String name, String phone);

    Record updateRecord(String name, String newPhoneNumber);

}
