package com.example.hotel.controller.web;

import com.example.hotel.service.interfaces.EvictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/v1/evictions")
public class EvictionOfRoomsUiController {
    @Autowired
    EvictionService evictionService;

    @RequestMapping("/")
    public String getAll(Model model){
        model.addAttribute("evictions", evictionService.getAll());
        return "evictions";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable String id){
        evictionService.delete(id);
        return "redirect:/ui/v1/evictions/";
    }
}
