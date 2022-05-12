package com.gridu.service;

import com.gridu.exception.InvalidArgumentException;
import com.gridu.exception.ResourceNotFoundException;
import com.gridu.model.Payload;
import com.gridu.model.Record;
import com.gridu.repository.InMemoryRepository;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PhoneBookService {
    void setRepository(InMemoryRepository repository);

    Set<Record> getAllRecords();

    void deleteRecordByName(String name) throws ResourceNotFoundException;

    Set<String> getPhonesByName(String name) throws ResourceNotFoundException;

    Record saveRecord(Payload payload) throws InvalidArgumentException;

    Record updateRecord(String name, String newPhoneNumber);

}
