package com.goku.webapi.controller;

import com.goku.webapi.config.log.LoggerInfo;
import com.goku.webapi.model.sysOrg;

/**
 * Created by nbfujx on 2017-11-22.
 */
public interface sysOrgController {
    @LoggerInfo(Method = "selectOrgByid",Name = "查询部门")
    String  selectOrgByid(String id);
    @LoggerInfo(Method = "selectOrgList",Name = "查询部门列表")
    String  selectOrgList(String parent_id, String orderFiled, String orderSort, int pageindex, int pagenum);
    @LoggerInfo(Method = "addOrg",Name = "新增部门")
    String  addOrg(sysOrg sysorg);
    @LoggerInfo(Method = "modifyOrg",Name = "修改部门")
    String  modifyOrg(sysOrg sysorg);
    @LoggerInfo(Method = "deleteOrg",Name = "删除部门")
    String  deleteOrg(String id);
}
