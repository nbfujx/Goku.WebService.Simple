package com.goku.webapi.controller;

import com.github.pagehelper.PageInfo;
import com.goku.webapi.config.log.LoggerInfo;
import com.goku.webapi.model.sysModule;

/**
 * Created by nbfujx on 2017-11-22.
 */
public interface sysModuleController {
    @LoggerInfo(Method = "selectModuleByid",Name = "查询模块")
    String selectModuleByid(String id);
    @LoggerInfo(Method = "selectModuleList",Name = "查询模块列表")
    String selectModuleList(String name, String orderFiled, String orderSort, int pageindex, int pagenum);
    @LoggerInfo(Method = "addModule",Name = "新增模块")
    String  addModule(sysModule sysmodule);
    @LoggerInfo(Method = "modifyModule",Name = "修改模块")
    String  modifyModule(sysModule sysmodule);
    @LoggerInfo(Method = "deleteModule",Name = "删除模块")
    String  deleteModule(String id);
}
