package com.gridu.service;

import com.gridu.model.Payload;
import com.gridu.model.Record;

import java.util.Set;

public interface PhoneBookService {

    Set<Record> getAllRecords();

    void deleteRecordByName(String name);

    Set<String> getPhonesByName(String name);

    Record saveRecord(Payload payload);

    Record updateRecord(String name, String newPhoneNumber);


}
