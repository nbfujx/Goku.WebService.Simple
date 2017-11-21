package com.goku.webapi.controller.impl;

import com.alibaba.fastjson.JSON;
import com.goku.webapi.controller.sysRoleController;
import com.goku.webapi.model.sysRole;
import com.goku.webapi.service.sysRoleService;
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
 * Created by nbfujx on 2017-11-21.
 */
@RestController
@RequestMapping("sysRole")
@Api(value="角色管理")
public class sysRoleControllerImpl implements sysRoleController {

    @Autowired
    sysRoleService sysroleservice;

    @Override
    @ApiOperation(value="角色查询", notes="角色信息查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色id", required = true, dataType = "String",paramType="path"),
    })
    @RequestMapping(value="getRole/{id}", method = RequestMethod.GET)
    @RequiresPermissions(value={"sysRole:selectRoleByid"})
    public String selectRoleByid(@PathVariable String id) {
        return JSON.toJSONString (new returnMsg(returnCode.SUCCESS,sysroleservice.selectByid(id)));
    }

    @Override
    @ApiOperation(value="角色查询", notes="角色列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderFiled", value = "", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "orderSort", value = "", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "pageindex", value = "当前页", dataType = "int",paramType="query"),
            @ApiImplicitParam(name = "pagenum", value = "页大小", dataType = "int",paramType="query"),
    })
    @RequestMapping(value="getRoleList", method = RequestMethod.GET)
    @RequiresPermissions(value={"sysRole:selectRoleList"})
    public String selectRoleList(@RequestParam(required=false) String orderFiled, @RequestParam(required=false) String orderSort,
                                 @RequestParam int pageindex,@RequestParam int pagenum) {
        return JSON.toJSONString (new returnMsg(returnCode.SUCCESS,sysroleservice.selectRoleList(orderFiled,orderSort,pageindex,pagenum)));
    }

    @Override
    @ApiOperation(value="角色新增", notes="角色新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysrole", value = "角色", required = true, dataType = "sysRole",paramType="body"),
    })
    @RequestMapping(value="addRole", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysRole:addRole"})
    public String addRole(@RequestBody sysRole addRole) {
        int result=sysroleservice.addRole(addRole);
        if(result>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }

    @Override
    @ApiOperation(value="角色修改", notes="角色修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysrole", value = "角色", required = true, dataType = "sysRole",paramType="body"),
    })
    @RequestMapping(value="modifyRole", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysRole:modifyRole"})
    public String modifyRole(@RequestBody sysRole sysrole) {
        int result=sysroleservice.modifyRole(sysrole);
        if(result>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }

    @Override
    @ApiOperation(value="角色删除", notes="角色删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色id", required = true, dataType = "String",paramType="path"),
    })
    @RequestMapping(value="deleteRole/{id}", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysRole:deleteRole"})
    public String deleteRole(@PathVariable String id) {
        int result=sysroleservice.deleteRole(id);
        if(result>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }
}
