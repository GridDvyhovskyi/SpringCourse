package com.gridu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;

import static com.gridu.util.JsonConverter.toJsonString;

@JsonPropertyOrder({ "name", "phone" })
public class Record {
    @JsonProperty("name")
    @NotEmpty
    private String name;
    @JsonProperty("phone")
    @NotEmpty
    @JsonUnwrapped
    private Set<String> phoneNumbers;

    public Record(@NotNull String name, @NotNull Set<String> phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    public void addAnotherPhone(String newPhoneNumber){
        Set<String> newPhones = new HashSet<>(this.getPhoneNumbers());
        newPhones.add(newPhoneNumber);
        this.setPhoneNumbers(newPhones);
        this.phoneNumbers.add(newPhoneNumber);
    }

    public String getName() {
        return name;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return name.equals(record.name) && Objects.equals(phoneNumbers, record.phoneNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumbers);
    }

    @Override
    public String toString(){
        return toJsonString(this);
    }
}
