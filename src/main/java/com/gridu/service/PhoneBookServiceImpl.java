//package com.gridu.service;
//
//import com.gridu.exception.ResourceNotFoundException;
//import com.gridu.model.Record;
//import com.gridu.repository.InMemoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service("phoneBookService")
//public class PhoneBookServiceImpl implements PhoneBookService {
//
//    private InMemoryRepository repository;
//
//    @Autowired
//    public PhoneBookServiceImpl(InMemoryRepository inMemoryRepository){
//        repository = inMemoryRepository;
//    }
//
//    /**
//     * injection is supported on setter level
//     *
//     * @param repository
//     */
//    @Override
//    public void setRepository(InMemoryRepository repository) {
//        this.repository = repository;
//    }
//
//    /**
//     * @return all pairs of type {name: [phone1, phone2]}
//     */
//    @Override
//    public List<Record> getAllRecords() {
//
//        return repository.findAll().keySet().stream().map(name -> new Record(name,
//                repository.findAll().get(name))).collect(Collectors.toList());
//    }
//
//    /**
//     * TODO: please add required methods here
//     */
//    @Override
//    public void add(Record newRecord){
//        this.repository.addPhone(newRecord.getName(), newRecord.getPhoneNumbers().iterator().next());
//    }
//
//    @Override
//    public Record updatePhones(String name, String phone) {
//        return null;
//    }
//
//    @Override
//    public void deleteRecordByName(String name) throws ResourceNotFoundException {
//        Record record = this.repository.findRecordByName(name).
//                orElseThrow(() -> new ResourceNotFoundException("Name", name));
//        this.repository.deleteRecordByName(record);
//    }
//
//    @Override
//    public Set<String> getPhonesByName(String name) throws ResourceNotFoundException {
//        Record record = this.repository.findRecordByName(name).
//                orElseThrow(() -> new ResourceNotFoundException("Name", name));
//        return record.getPhoneNumbers();
//    }
//
//    @Override
//    public Record saveRecord(String name, String phone) {
//        Record newRecord = new Record(name, phone);
//        this.repository.saveRecord(newRecord);
//        return newRecord;
//    }
//
//    @Override
//    public Record updateRecord(String name, String newPhoneNumber) {
//        this.repository.findRecordByName(name).get();
//    }
//
//
//}
