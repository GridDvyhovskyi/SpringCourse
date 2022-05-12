package com.gridu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

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
