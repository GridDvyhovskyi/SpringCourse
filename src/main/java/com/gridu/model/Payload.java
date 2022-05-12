package com.gridu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.gridu.util.JsonConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@JsonPropertyOrder({ "name", "phone" })
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payload {

    @JsonProperty("name")
    @NotEmpty
    private String name;
    @JsonProperty("phone")
    @NotEmpty
    @JsonUnwrapped
    private String phone;

}
