package com.saitej.controller;
import com.saitej.model.User;
import com.saitej.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;



@Controller
public class RegisterController {



    @ModelAttribute
    public void commonDataForModel(Model model){
        model.addAttribute("date", LocalDateTime.now());
    }

    @RequestMapping(value ="/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @Autowired
    private UserService userService;


//Using @ModelAttribute (automatically binds form fields with user fields)
    @RequestMapping(value = "/processForm",method = RequestMethod.POST)
    public String handleForm(@ModelAttribute User user,
                             Model model) {
        System.out.println(user);

        int i = userService.saveUser(user);
        model.addAttribute("i",i);

        //  model.addAttribute("user",user); // no need to add user into the model
        if (i>0) {
            return "success";
        }else {
            return "error";
        }

    }
    //Redirecting to register page using redirect:/url
    @RequestMapping("/login")
    public String loginUser(){

        return "redirect:/register";

    }

    //Redirecting to register page using RedirectView class
    @RequestMapping("/signup")
    public RedirectView signUpUser(){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("register");
        return redirectView;

    }

}
