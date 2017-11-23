package com.goku.webapi.controller;

import com.goku.webapi.config.log.LoggerInfo;
import com.goku.webapi.model.sysConfig;

/**
 * Created by nbfujx on 2017-11-23.
 */
public interface sysConfigController {
    @LoggerInfo(Method = "selectConfigList",Name = "查询字典列表")
    String selectConfigList(String remark, String orderFiled, String orderSort, int pageindex, int pagenum);
    @LoggerInfo(Method = "selectByid",Name = "查询字典")
    String selectByid(String id);
    @LoggerInfo(Method = "selectByKey",Name = "查询具体字典")
    String selectByKey(String key);
    @LoggerInfo(Method = "addConfig",Name = "新增字典")
    String  addConfig(sysConfig sysconfig);
    @LoggerInfo(Method = "modifyConfig",Name = "修改字典")
    String  modifyConfig(sysConfig sysconfig);
    @LoggerInfo(Method = "deleteConfig",Name = "删除字典")
    String  deleteConfig(String id);
    @LoggerInfo(Method = "selectBykeyAndid",Name = "查询具体字典值")
    String selectBykeyAndid(String key, String id);
}
