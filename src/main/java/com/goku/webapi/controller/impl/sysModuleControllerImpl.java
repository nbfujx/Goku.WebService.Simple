package com.goku.webapi.controller.impl;

import com.alibaba.fastjson.JSON;
import com.goku.webapi.controller.sysModuleController;
import com.goku.webapi.model.sysModule;
import com.goku.webapi.service.sysModuleService;
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
@RequestMapping("sysModule")
@Api(value="模块管理")
public class sysModuleControllerImpl implements sysModuleController {

    @Autowired
    sysModuleService sysmoduleservice;

    @Override
    @ApiOperation(value="模块查询", notes="模块查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "模块id", required = true, dataType = "String",paramType="path"),
    })
    @RequestMapping(value="getModule/{id}", method = RequestMethod.GET)
    @RequiresPermissions(value={"sysModule:selectModuleByid"})
    public String selectModuleByid(@PathVariable String id) {
        return JSON.toJSONString (new returnMsg(returnCode.SUCCESS,sysmoduleservice.selectByid(id)));
    }

    @Override
    @ApiOperation(value="模块查询", notes="模块列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "模块名称", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "orderFiled", value = "", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "orderSort", value = "", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "pageindex", value = "当前页", dataType = "int",paramType="query"),
            @ApiImplicitParam(name = "pagenum", value = "页大小", dataType = "int",paramType="query"),
    })
    @RequestMapping(value="getModuleList", method = RequestMethod.GET)
    @RequiresPermissions(value={"sysModule:getModuleList"})
    public String selectModuleList(@RequestParam(required=false) String name, @RequestParam(required=false) String orderFiled, @RequestParam(required=false) String orderSort,
                                    @RequestParam int pageindex, @RequestParam  int pagenum) {
        return JSON.toJSONString (new returnMsg(returnCode.SUCCESS,sysmoduleservice.selectModuleList(name,orderFiled,orderSort,pageindex,pagenum)));
    }

    @Override
    @ApiOperation(value="模块新增", notes="模块新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysmodule", value = "模块", required = true, dataType = "sysModule",paramType="body"),
    })
    @RequestMapping(value="addModule", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysModule:addModule"})
    public String addModule(@RequestBody sysModule sysmodule) {
        int result=sysmoduleservice.addModule(sysmodule);
        if(result>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }

    @Override
    @ApiOperation(value="模块修改", notes="模块修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysmodule", value = "模块", required = true, dataType = "sysModule",paramType="body"),
    })
    @RequestMapping(value="modifyModule", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysModule:modifyModule"})
    public String modifyModule(@RequestBody sysModule sysmodule) {
        int result=sysmoduleservice.modifyModule(sysmodule);
        if(result>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }

    @Override
    @ApiOperation(value="模块删除", notes="模块删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "模块id", required = true, dataType = "String",paramType="path"),
    })
    @RequestMapping(value="deleteModule/{id}", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysModule:deleteModule"})
    public String deleteModule(@PathVariable String id) {
        int result=sysmoduleservice.deleteModule(id);
        if(result>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }
}
