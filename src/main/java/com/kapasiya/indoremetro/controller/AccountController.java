package com.kapasiya.indoremetro.controller;


import com.kapasiya.indoremetro.entity.UserData;
import com.kapasiya.indoremetro.repo.UserDataRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AccountController
{

    @Autowired
    private UserDataRepository userDataRepository;
    @PostMapping("/register")
    public UserData register(@ModelAttribute UserData data, HttpSession session)
    {
        if(!data.getPassword().equals(data.getCpassword()))
        {
//            session.setAttribute("message","Both Password Miss match");
        }
        if (data.getNumber().length()<10)
        {
//            session.setAttribute("message","Number is Less then 10 Digits");
        }
        else
        {
            userDataRepository.save(data);
//            session.setAttribute("message","Success!!");
        }
        return data;
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
}
