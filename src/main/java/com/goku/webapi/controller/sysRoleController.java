package com.goku.webapi.controller;

import com.goku.webapi.config.log.LoggerInfo;
import com.goku.webapi.model.sysRole;

/**
 * Created by nbfujx on 2017-11-21.
 */
public interface sysRoleController {
    @LoggerInfo(Method = "selectRoleByid",Name = "查询角色")
    String  selectRoleByid(String id);
    @LoggerInfo(Method = "selectRoleList",Name = "查询角色列表")
    String  selectRoleList(String orderFiled,String orderSort, int pageindex, int pagenum);
    @LoggerInfo(Method = "addRole",Name = "新增角色")
    String  addRole(sysRole sysrole);
    @LoggerInfo(Method = "modifyRole",Name = "修改角色")
    String  modifyRole(sysRole sysrole);
    @LoggerInfo(Method = "deleteRole",Name = "删除角色")
    String  deleteRole(String id);
}
