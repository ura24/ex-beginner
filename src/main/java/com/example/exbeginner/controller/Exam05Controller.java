package com.example.exbeginner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exbeginner.domain.Member;
import com.example.exbeginner.repository.MemberRepository;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {

    @Autowired
    private MemberRepository repository;

    @GetMapping("")
    public String index() {
        return "exam05";
    }

    @PostMapping("/result")
    public String result(String name, Model model) {
        List<Member> memberList = repository.findByName(name);
        model.addAttribute("memberList", memberList);

        return "exam05-result";
    }
}
