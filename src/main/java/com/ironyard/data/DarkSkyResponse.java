package com.ironyard.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;

/**
 * Created by osmanidris on 2/28/17.
 */
@JsonIgnoreProperties
public class DarkSkyResponse {
    @JsonProperty
    private Currently currently;
    @JsonProperty
    private Minutely minutely;

    public Minutely getMinutely() {
        return minutely;
    }

    public void setMinutely(Minutely minutely) {
        this.minutely = minutely;
    }

    public Currently getCurrently() {
        return currently;
    }

    public void setCurrently(Currently currently) {
        this.currently = currently;
    }
}
