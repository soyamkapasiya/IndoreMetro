package com.kapasiya.indoremetro.controller;


import com.kapasiya.indoremetro.dto.UserRegisteredDTO;
import com.kapasiya.indoremetro.servicedef.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/registration"})
public class RegistrationController
{
    @Autowired
    private DefaultUserService userService;

    public RegistrationController(DefaultUserService userService)
    {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegisteredDTO userRegistrationDto() {
        return new UserRegisteredDTO();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegisteredDTO registrationDto)
    {
        registrationDto.setRole("USER");
        userService.save(registrationDto);
        return "redirect:/login";
    }
}
