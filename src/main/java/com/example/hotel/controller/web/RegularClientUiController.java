package com.example.hotel.controller.web;

import com.example.hotel.service.interfaces.RegularClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/v1/regular-clients")
public class RegularClientUiController {
    @Autowired
    RegularClientService regularClientService;

    @RequestMapping("/")
    public String getAll(Model model){
        model.addAttribute("regulars", regularClientService.getAll());
        return "regular-clients";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable String id){
        regularClientService.delete(id);
        return "redirect:/ui/v1/regular-clients/";
    }
}
