package com.goku.webapi.service;

import com.github.pagehelper.PageInfo;
import com.goku.webapi.model.sysMenu;


/**
 * Created by nbfujx on 2017/11/7.
 */
public interface sysMenuService {
    sysMenu selectByid(String id);
    PageInfo selectMenuList(String name, String type, String module_id,
                            String orderFiled, String orderSort,int pageindex,int pagenum);
    int  addMenu(sysMenu symenu);
    int  modifyMenu(sysMenu symenu);
    int  deleteMenu(String id);
}
