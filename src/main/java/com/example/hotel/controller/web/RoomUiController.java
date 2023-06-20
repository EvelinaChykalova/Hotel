package com.example.hotel.controller.web;

import com.example.hotel.service.interfaces.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/v1/rooms")
public class RoomUiController {
    @Autowired
    RoomService roomService;

    @RequestMapping("/")
    public String getAll(Model model){
        model.addAttribute("rooms", roomService.getAll());
        return "rooms";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable String id){
        roomService.delete(id);
        return "redirect:/ui/v1/rooms/";
    }
}
