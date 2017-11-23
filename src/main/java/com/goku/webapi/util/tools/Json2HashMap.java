package com.goku.webapi.util.tools;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by nbfujx on 2017-11-22.
 */
public class Json2HashMap {

    public static Map<Object, Object> jsonToMap(String jsonStr) {
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        Map<Object, Object> map = (Map)jsonObject;
        return map;
    }
}
