package com.goku.webapi.controller;

import com.goku.webapi.model.sysUser;
import java.util.List;
import java.util.Map;

/**
 * Created by nbfujx on 2017/10/15.
 */
public interface sysUserController {
    String  selectUserList(String username,String name,String status,
                           String org_id,String is_admin,
                           String orderFiled,String orderSort, int pageindex, int pagenum);
    String  selectUserByid(String id);
    String  addUser(sysUser sysuser);
    String  modifyUser(sysUser sysuser);
    String  deleteUser(String id);
    String  changeUserStatus(String id,String status);
}
