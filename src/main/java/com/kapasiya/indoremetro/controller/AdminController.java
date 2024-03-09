package com.kapasiya.indoremetro.controller;


import com.kapasiya.indoremetro.entity.MetroData;
import com.kapasiya.indoremetro.entity.User;
import com.kapasiya.indoremetro.repository.MetroDataRepository;
import com.kapasiya.indoremetro.repository.UserRepository;
import com.kapasiya.indoremetro.servicedef.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Secured("ROLE_ADMIN")
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MetroDataRepository metroDataRepository;

    @Autowired
    StationService stationService;


    @ModelAttribute("metroData")
    public MetroData metroData() {
        return new MetroData();
    }

    @GetMapping("/admin")
    public String displayDashboard(Model model){
        String user= returnUsername();
        model.addAttribute("userDetails", user);
        return "adminScreen";
    }

    @GetMapping("/admin/manageTrip")
    public String manageTrip(Model model){
        String user= returnUsername();
        model.addAttribute("station",stationService.getAllStations());
        model.addAttribute("userDetails", user);
        return "manageTrip";
    }



    private String returnUsername() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
        User users = userRepository.findByEmail(user.getUsername());
        return users.getName();
    }

    @PostMapping("/admin/manageTrip")
    public String saveBusData(@ModelAttribute("metroDetails") MetroData metroData,Model model){
        String user= returnUsername();
        model.addAttribute("metroDetails", user);
        System.out.println(metroData);
        metroDataRepository.save(metroData);
        model.addAttribute("metroDetails", new MetroData());
        return "redirect:/admin/manageTrip?success";
    }

    @GetMapping("/admin/allRecords")
    public String getAllRecords(Model model){
        List<MetroData> data = metroDataRepository.findAll();
        String user= returnUsername();
        model.addAttribute("userDetails", user);
        model.addAttribute("data", data);
        return "allRecords";
    }
    @GetMapping("/admin/delete/{id}")
    public String getDataAfterDelete(@PathVariable int id, Model model){
        metroDataRepository.deleteById(id);
        List<MetroData> data = metroDataRepository.findAll();
        String user= returnUsername();
        model.addAttribute("userDetails", user);
        model.addAttribute("data", data);
        return "redirect:/admin/allRecords?success";
    }

}
