package com.ironyard.controllers;

import com.ironyard.data.ChatUser;
import com.ironyard.repositories.ChatUserRepo;
import com.ironyard.util.ApiCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by osmanidris on 2/10/17.
 */
@Controller
public class UserController {
    @Autowired
    private ChatUserRepo chatUserRepo;

    @RequestMapping(path = "/open/authenticate", method = RequestMethod.POST)
    public String login(HttpSession session, Model myModel, @RequestParam(name = "username") String usr, @RequestParam String password){
        ChatUser found = chatUserRepo.findByUsernameAndPassword(usr, password);
        String destinationView = "home";
        if(found == null){
            // no user found, login must fail
            destinationView = "/open/login";
            myModel.addAttribute("message", true);
        }else{
            session.setAttribute ("user", found);
            destinationView = "forward:/secure/home.jsp";
        }
        return destinationView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:/secure/home";
    }


    @RequestMapping(path = "/secure/logout")
    public String login(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        String destinationView = "/open/login";
        return destinationView;
    }

}
