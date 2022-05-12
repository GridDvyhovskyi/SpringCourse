package com.gridu.repository;

import com.gridu.exception.ResourceNotFoundException;
import com.gridu.model.Record;

import java.util.Optional;
import java.util.Set;

public interface InMemoryRepository {
    /**
     * @return all repository records
     */
    Set<Record> findAll();

    /**
     * @param name
     * @return Record associated with a name
     */
    Optional<Record> findRecordByName(String name);

    /**
     * @param name
     * @return all phone numbers associated with a name
     */
    Set<String> findAllPhonesByName(String name);

    /**
     * add phone number for a name or create new record
     *
     * @param newRecord
     * @return newly created or updated Record
     */
    Record addRecord(Record newRecord);

    /**
     * removes a record from set
     *
     * @param name
     * @throws ResourceNotFoundException if there is no such phone in repo
     */

    void deleteRecordByName(String name);

}
