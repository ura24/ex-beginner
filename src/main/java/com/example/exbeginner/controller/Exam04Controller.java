package com.example.exbeginner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exbeginner.form.UserForm;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {

    @GetMapping("")
    public String index(UserForm userForm, Model model) {
        return "exam04";
    }

    @PostMapping("/showProfile")
    public String showProfile(
        @Validated UserForm userForm, 
        BindingResult result, 
        Model model
    ) {
        if (result.hasErrors()) {
            return index(userForm, model);
        }

        model.addAttribute("name", userForm.getName());
        model.addAttribute("age", userForm.getAge());
        model.addAttribute("comment", userForm.getComment());

        return "exam04-result";
    }
}
