package com.goku.webapi.service;

import com.github.pagehelper.PageInfo;
import com.goku.webapi.model.sysOrg;
import com.goku.webapi.util.treehelper.TreeInfo;

/**
 * Created by nbfujx on 2017-11-22.
 */
public interface sysOrgService {
    sysOrg selectByid(String id);
    PageInfo selectOrgList(String parent_id, String orderFiled, String orderSort, int pageindex, int pagenum);
    TreeInfo selectOrgTree();
    int  addOrg(sysOrg sysorg);
    int  modifyOrg(sysOrg sysorg);
    int  deleteOrg(String id);
}
