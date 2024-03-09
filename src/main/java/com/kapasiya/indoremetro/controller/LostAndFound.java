package com.kapasiya.indoremetro.controller;


import com.kapasiya.indoremetro.dto.UserRegisteredDTO;
import com.kapasiya.indoremetro.entity.LAFData;
import com.kapasiya.indoremetro.servicedef.LAFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LostAndFound
{

    @Autowired
    LAFService lafService;

    @ModelAttribute("user")
    public LAFData lafData() {
        return new LAFData();
    }

    @PostMapping("/addData")
    public String addLandFoundData(@ModelAttribute("data")LAFData data, Model model)
    {

        String date = String.valueOf(java.time.LocalDate.now());
        System.out.println(date);

        data.setDate(date);
        lafService.addLAFData(data);

        return "redirect:/lostAndFound";
    }
}
