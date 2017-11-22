package com.goku.webapi.controller;

import com.goku.webapi.config.log.LoggerInfo;
import com.goku.webapi.model.sysMenu;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by nbfujx on 2017/11/7.
 */
public interface sysMenuController {
    @LoggerInfo(Method = "selectMenuByid",Name = "查询菜单")
    String  selectMenuByid(String id);
    @LoggerInfo(Method = "selectMenuList",Name = "查询菜单列表")
    String  selectMenuList(String name,String type,String module_id,
                           String orderFiled,String orderSort, int pageindex, int pagenum);
    @LoggerInfo(Method = "addMenu",Name = "新增菜单")
    String  addMenu(sysMenu symenu);
    @LoggerInfo(Method = "modifyMenu",Name = "修改菜单")
    String  modifyMenu(sysMenu symenu);
    @LoggerInfo(Method = "deleteMenu",Name = "删除菜单")
    String  deleteMenu(String id);
}
