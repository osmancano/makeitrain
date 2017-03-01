package com.ironyard.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by osmanidris on 2/28/17.
 */
@JsonIgnoreProperties
public class Result {
    @JsonProperty(value = "formatted_address")
    String formatedAddress;

    public String getFormatedAddress() {
        return formatedAddress;
    }

    public void setFormatedAddress(String formatedAddress) {
        this.formatedAddress = formatedAddress;
    }
}
