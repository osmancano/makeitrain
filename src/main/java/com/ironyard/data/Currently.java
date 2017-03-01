package com.ironyard.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


/**
 * Created by osmanidris on 2/28/17.
 */
@Entity
@JsonIgnoreProperties
public class Currently {
    @Id
    @GeneratedValue
    private long id;
    private String latitude;
    private String longitude;
    private String dateTime;
    private String formatedAddress;
    @JsonProperty(value = "time")
    private Long time;
    @JsonProperty
    private String summary;
    @JsonProperty(value = "icon")
    private String icon;
    @JsonProperty
    private Double temperature;
    @JsonProperty
    private Double humidity;
    @JsonProperty
    private Double cloudCover;
    @JsonProperty
    private Double windSpeed;
    @JsonProperty
    private Integer windBearing;
    @JsonProperty
    private Double pressure;
    @JsonProperty
    private Double visibility;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getFormatedAddress() {
        return formatedAddress;
    }

    public void setFormatedAddress(String formatedAddress) {
        this.formatedAddress = formatedAddress;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(Double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(Integer windBearing) {
        this.windBearing = windBearing;
    }
}
