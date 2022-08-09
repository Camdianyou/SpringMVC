package com.liang.controller;

import com.liang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    //restful风格 localhost:8080/user/t1/xxx
    //@PathVariable其中的一种写法,这种方法记得在Url的后面加上{ParamName}
    //@RequestParam这个注解表示这个参数是需要从前端接收的
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model) {
        //1.接受前端传过来的参数
        System.out.println(name);

        //2.将接收到的参数返回到前端
        model.addAttribute("msg", name);

        //3.视图跳转
        return "test";
    }

    /*
    * 1.接收前端用户传递过来的参数，判断参数的名字，假设名字直接在方法上面，可以直接使用
    * 2.假设传递过来的是一个对象(User),就会自动匹配对象中的属性字段，如果字段的名字相同，也可以传递成功
    *   http://localhost:8080/user/t2?id=1&name=liangpeng&age=18
    * 如果传递的对象的字段与实体类中的属性字段不匹配，就会返回null
    * */
    //从前端接收到一个对象：id,name,age
    @RequestMapping("/t2")
    public String test2(User user){
        System.out.println(user);
        return "test";
    }
}
