package com.example.exbeginner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {

  @Autowired
  private HttpSession session;
  
  @GetMapping("")
  public String index() {
    return "exam02";
  }

  @PostMapping("/calc")
  public String calc(Integer num1, Integer num2) {    
    session.setAttribute("num1", num1);
    session.setAttribute("num2", num2);

    int result = num1 + num2;
    session.setAttribute("result", result);

    return "exam02-result";
  }

  @GetMapping("/to-page2") 
  public String toPage2() {
    return "exam02-result2";
  }
}
