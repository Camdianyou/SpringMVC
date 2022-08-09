package com.liang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//下面直接使用请求和响应就不需要使用视图解析器,直接去请求页面进行跳转
//下面的跳转方法全部都是在没有视图解析器的情况下也可以进行跳转
@Controller
public class ModelTest {
    @RequestMapping("/m1/t1")
    public String test(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getSession().getId());
        //return "test";

        //转发
        //return "/WEB-INF/jsp/test.jsp";
        //转发
        //return "forward:/WEB-INF/jsp/test.jsp";
        //重定向
        return "redirect:/index.jsp";
    }
}
