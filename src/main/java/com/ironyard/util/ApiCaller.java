package com.ironyard.util;

import com.ironyard.data.DarkSkyResponse;
import com.ironyard.data.GoogleResponse;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created by osmanidris on 2/23/17.
 */
public class ApiCaller {
    RestTemplate restTemplate;
    String url;
    String darkSkyKey;
    public ApiCaller(){
        restTemplate = new RestTemplate();
        darkSkyKey = "88daaf7ef8dd640f69545535796854d5";
    }

    private HttpEntity getHeaders()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity headersEntity = new HttpEntity(headers);
        return headersEntity;
    }

    public String getFormatedAddress(String latitude, String longitude){
        url = "http://maps.googleapis.com/maps/api/geocode/json?latlng="+latitude+","+longitude+"&sensor=false";
        GoogleResponse googleResponse = restTemplate.exchange(url, HttpMethod.GET,getHeaders(),GoogleResponse.class).getBody();
        return googleResponse.getResults().get(0).getFormatedAddress();
    }

    public DarkSkyResponse getDarkSkyResponse(String latitude, String longitude){
        url = "https://api.darksky.net/forecast/"+darkSkyKey+"/"+latitude+","+longitude;
        DarkSkyResponse darkSkyResponse = restTemplate.exchange(url, HttpMethod.GET,getHeaders(),DarkSkyResponse.class).getBody();
        return darkSkyResponse;
    }
}