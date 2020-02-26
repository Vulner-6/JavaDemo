package com.example.javademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class XSSController
{
    @GetMapping("/")
    public String xss(
            Model model)
    {
        return "xss";
    }
}
