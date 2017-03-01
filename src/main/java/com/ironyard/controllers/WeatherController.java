package com.ironyard.controllers;

import com.ironyard.data.*;
import com.ironyard.repositories.ChatUserRepo;
import com.ironyard.util.ApiCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by osmanidris on 2/28/17.
 */
@Controller
@Transactional
public class WeatherController {
    @Autowired
    private ChatUserRepo chatUserRepo;
    @RequestMapping(path = "/forecast", method = RequestMethod.POST)
    public String getWeather(HttpSession session, Model model,
                             @RequestParam(required = false) String latitude,
                             @RequestParam(required = false) String longitude) {
        String formatedAddress = (new ApiCaller()).getFormatedAddress(latitude,longitude);
        DarkSkyResponse darkSkyResponse = (new ApiCaller()).getDarkSkyResponse(latitude,longitude);
        Currently currently = darkSkyResponse.getCurrently();
        Minutely minutely = darkSkyResponse.getMinutely();
        ChatUser user = (ChatUser) session.getAttribute("user");
        Date date = new Date(currently.getTime()*1000);
        currently.setLatitude(latitude);
        currently.setLongitude(longitude);
        currently.setDateTime(date.toString());
        currently.setFormatedAddress(formatedAddress);
        user.getHistory().add(currently);
        chatUserRepo.save(user);
        System.out.println(formatedAddress);
        model.addAttribute("formatedAddress", formatedAddress);
        model.addAttribute("currently", currently);
        model.addAttribute("minutely", minutely);
        model.addAttribute("dateTime",date.toString());
        return "/secure/home";
    }
}
