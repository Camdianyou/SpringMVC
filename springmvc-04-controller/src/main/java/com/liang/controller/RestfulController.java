package com.liang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestfulController {

    //原来的方式，前端必须在Url中传入a,b的值
    //localhost:8080/add?a=1&b=2

    //Restful风格应该为：localhost:8080/add/a/b
    //通过PathVariable注解在RequestMapping中传入参数
    //value的值就是Url method的值是请求方式
    /*@RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.GET)
    //value 和 path两个参数都是可以的
    public String test1(@PathVariable int a, @PathVariable int b, Model model){
        int res = a + b;
        model.addAttribute("msg","结果为"+res);
        return "test";
    }*/

    /*相同的Url地址，但是请求提交方式不同，可能会产生不同的结果*/
    //localhost:8080/add/1/3
    @PostMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a,@PathVariable int b,Model model){
        int res = a + b;
        model.addAttribute("msg","test1结果为"+res);
        return "test";
    }
    //虽然两个请求的Url是一样的，但是因为服务器发出的是GET请求，所以会自动跳转的下面这个GET请求执行
    //localhost:8080/add/1/2
    @GetMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a,@PathVariable int b,Model model){
        int res = a + b;
        model.addAttribute("msg","test2结果为"+res);
        return "test";
    }
}
