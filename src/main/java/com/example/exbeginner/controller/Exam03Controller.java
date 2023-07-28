package com.example.exbeginner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
  
  @GetMapping("")
  public String index() {
    return "exam03";
  }

  @PostMapping("/calc")
  public String cald(int item1, int item2, int item3, Model model) {
    int taxExcludedPrice = item1 + item2 + item3;
    int taxIncludedPrice = (int) (taxExcludedPrice * 1.1);
    
    model.addAttribute("taxExcludedPrice", taxExcludedPrice);
    model.addAttribute("taxIncludedPrice", taxIncludedPrice);

    return "exam03-result";
  }
}
