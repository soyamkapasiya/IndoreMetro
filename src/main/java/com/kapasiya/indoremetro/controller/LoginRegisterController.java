package com.kapasiya.indoremetro.controller;


import com.kapasiya.indoremetro.dto.UserLoginDTO;
import com.kapasiya.indoremetro.dto.UserRegisteredDTO;
import com.kapasiya.indoremetro.servicedef.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginRegisterController
{
    @Autowired
    private DefaultUserService userService;

    @GetMapping("/login")
    public String loginRegister()
    {
        return "loginRegister";
    }
    public LoginRegisterController(DefaultUserService userService)
    {
        super();
        this.userService = userService;
    }

    @ModelAttribute("userLogin")
    public UserLoginDTO userLoginDTO() {
        return new UserLoginDTO();
    }
    @ModelAttribute("userRegister")
    public UserRegisteredDTO userRegistrationDto() {
        return new UserRegisteredDTO();
    }

    @PostMapping("/login")
    public void  loginUser(@ModelAttribute("userLogin") UserLoginDTO userLoginDTO)
    {
        System.out.println(userLoginDTO);
        userService.loadUserByUsername(userLoginDTO.getUsername());
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("userRegister") UserRegisteredDTO userRegisteredDTO)
    {
        userRegisteredDTO.setRole("USER");
        System.out.println(userRegisteredDTO);

        userService.save(userRegisteredDTO);

        return"redirect:/login";
    }
}
