package com.liang.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.beans.binding.ObjectExpression;

import java.text.SimpleDateFormat;
import java.util.List;

//对于时间对象的JSON格式转换的封装类
public class JsonUtils {

    public static String getJson(Object object) throws JsonProcessingException {
        //两种方法都是可以完成复用的操作的，直接重写方法完成复用
        //return getJson(object,"yyyy-MM-dd HH:mm:ss");
        return new ObjectMapper().writeValueAsString(object);
    }

    public static String getJson(Object object, String dateFormat) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        //设置时间格式
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS,false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        mapper.setDateFormat(simpleDateFormat);

        return mapper.writeValueAsString(object);
    }

}
