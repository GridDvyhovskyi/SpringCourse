package com.gridu.repository;

import com.gridu.exception.ResourceNotFoundException;
import com.gridu.model.Record;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository("phoneBookRepository")
public class InMemoryRepositoryImpl implements InMemoryRepository {

    private Set<Record> data;

    /**
     * no args constructor
     */
    public InMemoryRepositoryImpl() {
        this(new HashMap<>());
    }

    /**
     * this constructor allows to inject initial data to the repository
     *
     * @param data
     */
    public InMemoryRepositoryImpl(Map<String, Set<String>> data) {
        this.data = data.keySet().stream().map(name ->
                new Record(name, data.get(name))).collect(Collectors.toSet());
    }

    @Override
    public Set<Record> findAll() {
        return this.data;
    }

    public Optional<Record> findRecordByName(String name) throws ResourceNotFoundException{
       return this.data.stream().filter(r -> r.getName().equals(name)).findFirst();
    }

    @Override
    public Set<String> findAllPhonesByName(String name) throws ResourceNotFoundException {
        Record record = this.findRecordByName(name).
                orElseThrow(() -> new ResourceNotFoundException("Name", name));
        return record.getPhoneNumbers();
    }

    @Override
    public void deleteRecordByName(String name) throws ResourceNotFoundException {
        Record foundRecord = this.findRecordByName(name).
                orElseThrow(() -> new ResourceNotFoundException("Name", name));
        this.data.remove(foundRecord);
    }

    @Override
    public Record addPhone(String name, String phone)  {
            Record foundRecord = this.findRecordByName(name).
                    orElse(null);
            if (foundRecord == null) {
                foundRecord = new Record(name, Set.of(phone));
                this.data.add(foundRecord);
            } else {
                foundRecord.addAnotherPhone(phone);
            }
        return foundRecord;
    }

}
