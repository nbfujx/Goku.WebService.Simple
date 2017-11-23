package com.goku.webapi.util.dichelper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nbfujx on 2017-11-23.
 */
public class Json2DicInfo {

    public static List<DicInfo>  jsonToDicInfo(String jsonStr)
    {
        ArrayList<DicInfo> DicInfo = JSON.parseObject(jsonStr, new TypeReference<ArrayList<DicInfo>>() {});
        return DicInfo;
    }
}
