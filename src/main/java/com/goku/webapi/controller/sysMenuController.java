package com.goku.webapi.controller;

import com.goku.webapi.model.sysMenu;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by nbfujx on 2017/11/7.
 */
public interface sysMenuController {
    String  selectMenuByid(String id);
    String  selectMenuList(String name,String type,String module_id,
                           String orderFiled,String orderSort, int pageindex, int pagenum);
    String  addMenu(sysMenu symenu);
    String  modifyMenu(sysMenu symenu);
    String  deleteMenu(String id);
}
