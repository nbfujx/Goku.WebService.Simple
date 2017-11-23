package com.goku.webapi.service;

import com.github.pagehelper.PageInfo;
import com.goku.webapi.model.sysRole;
import com.goku.webapi.util.treehelper.TreeInfo;

/**
 * Created by nbfujx on 2017-11-21.
 */
public interface sysRoleService {
    sysRole selectByid(String id);
    PageInfo selectRoleList(String orderFiled, String orderSort, int pageindex, int pagenum);
    TreeInfo selectRoleTree();
    int  addRole(sysRole sysrole);
    int  modifyRole(sysRole sysrole);
    int  deleteRole(String id);
}
