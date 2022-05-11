package com.gridu.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;

public class JsonConverter {

    public static String toJsonString(Object o){
        ObjectMapper mapperObj = new ObjectMapper();
        try {
            return mapperObj.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
