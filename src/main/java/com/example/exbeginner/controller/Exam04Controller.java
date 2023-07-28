package com.example.exbeginner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exbeginner.form.UserForm;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
    
    @GetMapping("")
    public String index(UserForm userform) {
        return "exam04";
    }

    @PostMapping("showProfile")
    public String showProfile(UserForm userForm, Model model) {
        model.addAttribute("name", userForm.getName());
        model.addAttribute("age", userForm.getAge());
        model.addAttribute("comment", userForm.getComment());

        return "exam04-result";
    }
}
