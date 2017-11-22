package com.goku.webapi.controller;

import com.goku.webapi.config.log.LoggerInfo;
import com.goku.webapi.model.sysUser;
import java.util.List;
import java.util.Map;

/**
 * Created by nbfujx on 2017/10/15.
 */
public interface sysUserController {
    @LoggerInfo(Method = "selectUserList",Name = "查询用户列表")
    String  selectUserList(String username,String name,String status,
                           String org_id,String is_admin,
                           String orderFiled,String orderSort, int pageindex, int pagenum);
    @LoggerInfo(Method = "selectUserByid",Name = "查询用户")
    String  selectUserByid(String id);
    @LoggerInfo(Method = "addUser",Name = "新增用户")
    String  addUser(sysUser sysuser);
    @LoggerInfo(Method = "modifyUser",Name = "修改用户")
    String  modifyUser(sysUser sysuser);
    @LoggerInfo(Method = "deleteUser",Name = "删除用户")
    String  deleteUser(String id);
    @LoggerInfo(Method = "changeUserStatus",Name = "修改用户状态")
    String  changeUserStatus(String id,String status);
}
