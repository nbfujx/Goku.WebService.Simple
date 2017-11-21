package com.goku.webapi.service;



import com.github.pagehelper.PageInfo;
import com.goku.webapi.config.druid.DataSource;
import com.goku.webapi.model.sysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by nbfujx on 2017/10/14.
 */
public interface sysUserService {
    sysUser selectByid(String id);
    PageInfo selectUserList(String username, String name, String status, String org_id,
                            String is_admin, String orderFiled, String orderSort, int pageindex, int pagenum);
    int  addUser(sysUser sysuser);
    int  modifyUser(sysUser sysuser);
    int  deleteUser(String id);
    int  changeUserStatus(String id,String status);
}
