package com.goku.webapi.controller.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goku.webapi.controller.sysUserController;

import com.goku.webapi.model.sysUser;
import com.goku.webapi.service.sysUserService;
import com.goku.webapi.util.enums.returnCode;
import com.goku.webapi.util.message.returnMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by nbfujx on 2017/10/15.
 */
@RestController
@RequestMapping("sysUser")
@Api(value="用户管理")
public class sysUserControllerImpl implements sysUserController {

    private Logger logger = LoggerFactory.getLogger(sysUserControllerImpl.class);

    @Autowired
    sysUserService sysuserService;

    @Override
    @ApiOperation(value="用户查询", notes="用户列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "name", value = "用户姓名", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "status", value = "用户状态", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "org_id", value = "用户部门", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "is_admin", value = "是否管理员", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "orderFiled", value = "", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "orderSort", value = "", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "pageindex", value = "当前页", dataType = "int",paramType="query"),
            @ApiImplicitParam(name = "pagenum", value = "页大小", dataType = "int",paramType="query"),
    })
    @RequestMapping(value="getUserList", method = RequestMethod.GET)
    @RequiresPermissions(value={"sysUser:selectUserByid"})
    public String selectUserList(@RequestParam(required=false) String username, @RequestParam(required=false)  String name,
                                 @RequestParam(required=false)  String status, @RequestParam(required=false)  String org_id, @RequestParam(required=false)  String is_admin,
                                 @RequestParam(required=false)  String orderFiled, @RequestParam(required=false)  String orderSort,
                                 @RequestParam int pageindex, @RequestParam int pagenum) {
         return JSON.toJSONString (new returnMsg(returnCode.SUCCESS,sysuserService.selectUserList(username,name,status,org_id,is_admin,orderFiled,orderSort,pageindex,pagenum)));
    }

    @Override
    @ApiOperation(value="用户查询", notes="用户信息查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String",paramType="path"),
    })
    @RequestMapping(value="getUser/{id}", method = RequestMethod.GET)
    @RequiresPermissions(value={"sysUser:selectUserByid"})
    public String  selectUserByid(@PathVariable String id) {
        return JSON.toJSONString (new returnMsg(returnCode.SUCCESS,sysuserService.selectByid(id)));
    }

    @Override
    @ApiOperation(value="用户新增", notes="用户信息新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysuser", value = "用户", required = true, dataType = "sysUser",paramType="body"),
    })
    @RequestMapping(value="addUser", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysUser:addUser"})
    public String addUser(@RequestBody sysUser sysuser) {
        int returnint=sysuserService.addUser( sysuser);
        if(returnint>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }

    @Override
    @ApiOperation(value="用户修改", notes="用户信息修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysuser", value = "用户", required = true, dataType = "sysUser",paramType="body"),
    })
    @RequestMapping(value="modifyUser", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysUser:modifyUser"})
    public String modifyUser(@RequestBody sysUser sysuser) {
        int returnint=sysuserService.modifyUser(sysuser);
        if(returnint>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }

    @Override
    @ApiOperation(value="用户删除", notes="用户信息删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String",paramType="path"),
    })
    @RequestMapping(value="deleteUser/{id}", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysUser:deleteUser"})
    public String deleteUser(@PathVariable  String id) {
        int returnint=sysuserService.deleteUser(id);
        if(returnint>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }

    @Override
    @ApiOperation(value="用户状态修改", notes="用户状态修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String",paramType="path"),
            @ApiImplicitParam(name = "status", value = "用户状态", required = true, dataType = "String",paramType="path"),
    })
    @RequestMapping(value="changeUserStatus/{id}/{status}", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysUser:changeUserStatus"})
    public String changeUserStatus(@PathVariable String id, @PathVariable String status) {
        int returnint=sysuserService.changeUserStatus(id,status);
        if(returnint>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }
}
