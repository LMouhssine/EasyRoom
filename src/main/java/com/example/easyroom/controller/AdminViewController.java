package com.example.easyroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminViewController {
    @GetMapping("/admins")
    public String getAdminsPage() {
        return "admins";
    }
}