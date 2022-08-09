package com.liang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EncodingController {

    //传递中文的时候可能会出现乱码的情况
    @PostMapping("/e/t1")
    public String test(String name, Model model){

        System.out.println(name);
        model.addAttribute("msg",name);

        return "test";
    }
}
