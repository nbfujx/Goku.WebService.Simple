package com.goku.webapi.controller.impl;

import com.alibaba.fastjson.JSON;
import com.goku.webapi.controller.sysOrgController;
import com.goku.webapi.model.sysOrg;
import com.goku.webapi.service.sysOrgService;
import com.goku.webapi.util.enums.returnCode;
import com.goku.webapi.util.message.returnMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nbfujx on 2017-11-22.
 */
@RestController
@RequestMapping("sysOrg")
@Api(value="部门管理")
public class sysOrgControllerImpl implements sysOrgController {

    @Autowired
    sysOrgService sysorgservice;

    @Override
    @ApiOperation(value="部门查询", notes="部门查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "部门id", required = true, dataType = "String",paramType="path"),
    })
    @RequestMapping(value="getOrg/{id}", method = RequestMethod.GET)
    @RequiresPermissions(value={"sysOrg:selectOrgByid"})
    public String selectOrgByid(@PathVariable String id) {
        return JSON.toJSONString (new returnMsg(returnCode.SUCCESS,sysorgservice.selectByid(id)));
    }

    @Override
    @ApiOperation(value="部门查询", notes="部门列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parent_id", value = "部门父级id", required = true, dataType = "String",paramType="path"),
            @ApiImplicitParam(name = "orderFiled", value = "", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "orderSort", value = "", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "pageindex", value = "当前页", dataType = "int",paramType="query"),
            @ApiImplicitParam(name = "pagenum", value = "页大小", dataType = "int",paramType="query"),
    })
    @RequestMapping(value="getOrgList", method = RequestMethod.GET)
    @RequiresPermissions(value={"sysOrg:selectOrgList"})
    public String selectOrgList(@RequestParam(required=false) String parent_id, @RequestParam(required=false) String orderFiled, @RequestParam(required=false) String orderSort,
                                 @RequestParam int pageindex, @RequestParam int pagenum) {
        return JSON.toJSONString (new returnMsg(returnCode.SUCCESS,sysorgservice.selectOrgList(parent_id,orderFiled,orderSort,pageindex,pagenum)));
    }

    @Override
    @ApiOperation(value="部门新增", notes="部门新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysorg", value = "部门", required = true, dataType = "sysOrg",paramType="body"),
    })
    @RequestMapping(value="addOrg", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysOrg:addOrg"})
    public String addOrg(@RequestBody sysOrg sysorg) {
        int result=sysorgservice.addOrg(sysorg);
        if(result>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }

    @Override
    @ApiOperation(value="部门修改", notes="部门修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysorg", value = "部门", required = true, dataType = "sysOrg",paramType="body"),
    })
    @RequestMapping(value="modifyOrg", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysOrg:modifyOrg"})
    public String modifyOrg(@RequestBody sysOrg sysorg) {
        int result=sysorgservice.modifyOrg(sysorg);
        if(result>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }

    @Override
    @ApiOperation(value="部门删除", notes="部门删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "部门id", required = true, dataType = "String",paramType="path"),
    })
    @RequestMapping(value="deleteOrg/{id}", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysOrg:deleteOrg"})
    public String deleteOrg(@PathVariable String id) {
        int result=sysorgservice.deleteOrg(id);
        if(result>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }
}
