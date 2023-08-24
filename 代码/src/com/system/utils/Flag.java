package com.system.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回设置
 */
public class Flag {

    //返回成功
    public static String getSuccess(Map m) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = new HashMap();
        map.put("flag",true);
        if(m != null){
            map.putAll(m);
        }
        String s = objectMapper.writeValueAsString(map);
        return s;
    }

    //返回失败
    public static String getFail(Map m) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = new HashMap();
        map.put("flag",false);
        if(m != null){
            map.putAll(m);
        }
        String s = objectMapper.writeValueAsString(map);
        return s;
    }

    //返回消息
    public static String getMsg(Map m) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = new HashMap();
        if(m != null){
            map.putAll(m);
        }
        String s = objectMapper.writeValueAsString(map);
        return s;
    }
}