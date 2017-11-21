package com.goku.webapi.controller;

import com.goku.webapi.model.sysRole;

/**
 * Created by nbfujx on 2017-11-21.
 */
public interface sysRoleController {
    String  selectRoleByid(String id);
    String  selectRoleList(String orderFiled,String orderSort, int pageindex, int pagenum);
    String  addRole(sysRole sysrole);
    String  modifyRole(sysRole sysrole);
    String  deleteRole(String id);
}
