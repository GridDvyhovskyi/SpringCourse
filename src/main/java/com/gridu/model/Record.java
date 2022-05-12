package com.gridu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;

@JsonPropertyOrder({ "name", "phone" })
@Data
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
    }

//    @Override
//    public String toString(){
//        return jsonConverter.toJsonString(this);
//    }
}
