package com.liang.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liang.pojo.User;
import com.liang.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//标注了RestController下面的所有的方法都只会走JSON的字符串,不会走视图解析器
@RestController
public class UserController {

    //在produces中加入一个乱码的解析，防止出现乱码
    @RequestMapping("/j1")
    //@ResponseBody //加上这个注解的话，这个方法就不会走视图解析器,会直接返回一个字符串
    //写上RestController注解的话就不需要这个注解了，这个注解主要是配合Controller这个注解使用的为了返回JSON字符串
    public String json1() throws JsonProcessingException {
        //1.Jackson ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("liujing", 18, "女");
        //Jackson中的这个方法会将对象转换成一个字符串
        String s = mapper.writeValueAsString(user);
        return s;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> userList = new ArrayList<>();

        User user = new User("liujing", 18, "女");
        User user1 = new User("xuxuanxuan", 18, "女");
        User user2 = new User("guotaipeng", 18, "男");
        User user3 = new User("lishuning", 18, "女");

        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        String str = mapper.writeValueAsString(userList);

        return str;
    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();


        //方式一
        //自定义格式化时间
        //纯Java的形式来解决时间格式的问题
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String format = simpleDateFormat.format(date);

        //方式二
        //直接使用mapper中的方法将原来设置的时间戳格式关闭
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS,false);
        mapper.setDateFormat(simpleDateFormat);

        Date date = new Date();

        System.out.println(date);
        //时间解析后的默认格式为时间戳
        return mapper.writeValueAsString(date);
    }

    @RequestMapping("/j4")
    public String json4() throws JsonProcessingException {
        Date date = new Date();
        return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }

    @RequestMapping("/j5")
    public String json5() throws JsonProcessingException {
        List<User> userList = new ArrayList<>();
        User user = new User("liujing", 18, "女");
        User user1 = new User("xuxuanxuan", 18, "女");
        User user2 = new User("guotaipeng", 18, "男");
        User user3 = new User("lishuning", 18, "女");

        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return JsonUtils.getJson(userList);

    }

    //FastJson案列
    @RequestMapping("/j6")
    public String test6(){
        //在使用新的依赖的时候记得把Project Structure配置一下
        List<User> userList = new ArrayList<>();

        User user = new User("liujing", 18, "女");
        User user1 = new User("xuxuanxuan", 18, "女");
        User user2 = new User("guotaipeng", 18, "男");
        User user3 = new User("lishuning", 18, "女");

        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        String s = JSON.toJSONString(userList);
        System.out.println(JSON.toJSON(userList));

        //Java对象变成JSON对象
        JSONObject json = (JSONObject) JSON.toJSON(user1);
        System.out.println(json);
        //JSON变成Java对象;
        User user4 = JSON.toJavaObject(json, User.class);
        System.out.println(user4);
        return s;
    }
}
