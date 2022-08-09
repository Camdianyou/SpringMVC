package com.liang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//加上Controller这个注解，整个类都会自动走视图解析器.
public class ControllerTest2 {

    @RequestMapping("/test2")
    public String test2(Model model){
        model.addAttribute("msg","ControllerTest2");
        return "test";
    }

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg","Hello,SpringMVC");
        return "test";
    }
}
