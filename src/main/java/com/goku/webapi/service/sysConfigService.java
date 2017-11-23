package com.goku.webapi.service;

import com.github.pagehelper.PageInfo;
import com.goku.webapi.model.sysConfig;
import com.goku.webapi.util.dichelper.DicInfo;

import java.util.List;

/**
 * Created by nbfujx on 2017-11-23.
 */
public interface sysConfigService {
    PageInfo selectConfigList(String remark, String orderFiled, String orderSort, int pageindex, int pagenum);
    sysConfig selectByid(String id);
    List<DicInfo>  selectByKey(String key);
    int  addConfig(sysConfig sysconfig);
    int  modifyConfig(sysConfig sysconfig);
    int  deleteConfig(String id);
    DicInfo selectBykeyAndid(String key, String id);
}
