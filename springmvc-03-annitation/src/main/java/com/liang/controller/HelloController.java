package com.liang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//Controller注解可以使得我们的这个类被视图解析器识别

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        //封装数据
        //向模型中添加msg属性与值,可以在Jsp中取出并渲染
        model.addAttribute("msg","Hello,SpringMVC");

        //WEB-INF/jsp/hello.jsp
        return "hello";//会被视图解析器处理,会通过配置文件中的视图解析器，跳转到hello.jsp
    }
}
