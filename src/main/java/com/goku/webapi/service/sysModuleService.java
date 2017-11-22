package com.goku.webapi.service;

import com.github.pagehelper.PageInfo;
import com.goku.webapi.model.sysModule;


/**
 * Created by nbfujx on 2017-11-22.
 */
public interface sysModuleService {
    sysModule selectByid(String id);
    PageInfo selectModuleList(String name, String orderFiled, String orderSort, int pageindex, int pagenum);
    int  addModule(sysModule sysmodule);
    int  modifyModule(sysModule sysmodule);
    int  deleteModule(String id);
}
