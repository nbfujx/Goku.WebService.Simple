package com.goku.webapi.controller.impl;

import com.alibaba.fastjson.JSON;
import com.goku.webapi.controller.sysConfigController;
import com.goku.webapi.model.sysConfig;
import com.goku.webapi.service.sysConfigService;
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
 * Created by nbfujx on 2017-11-23.
 */
@RestController
@RequestMapping("sysConfig")
@Api(value="字典管理")
public class sysConfigControllerImpl implements sysConfigController {

    @Autowired
    sysConfigService sysconfigservice;

    @Override
    @ApiOperation(value="字典查询", notes="字典列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "remark", value = "字典名称", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "orderFiled", value = "", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "orderSort", value = "", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "pageindex", value = "当前页", dataType = "int",paramType="query"),
            @ApiImplicitParam(name = "pagenum", value = "页大小", dataType = "int",paramType="query"),
    })
    @RequestMapping(value="getConfigList", method = RequestMethod.GET)
    @RequiresPermissions(value={"sysConfig:getConfigList"})
    public String selectConfigList(@RequestParam(required=false) String remark, @RequestParam(required=false) String orderFiled, @RequestParam(required=false) String orderSort,
                                    @RequestParam int pageindex, @RequestParam int pagenum) {
        return JSON.toJSONString (new returnMsg(returnCode.SUCCESS,
                sysconfigservice.selectConfigList(remark,orderFiled,orderSort,pageindex,pagenum)));
    }

    @Override
    @RequestMapping(value="getConfig/{id}", method = RequestMethod.GET)
    @RequiresPermissions(value={"sysConfig:selectByid"})
    @ApiOperation(value="字典查询", notes="字典信息查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "字典id", required = true, dataType = "String",paramType="path"),
    })
    public String selectByid(@PathVariable String id) {
       return JSON.toJSONString (new returnMsg(returnCode.SUCCESS,sysconfigservice.selectByid(id)));
    }

    @Override
    @ApiOperation(value="字典查询", notes="字典查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "字典key值", required = true, dataType = "String",paramType="path"),
    })
    @RequestMapping(value="getDic/{key}", method = RequestMethod.GET)
    @RequiresPermissions(value={"sysConfig:selectByKey"})
    public String selectByKey(@PathVariable String key) {
        return JSON.toJSONString (new returnMsg(returnCode.SUCCESS,sysconfigservice.selectByKey(key)));
    }

    @Override
    @ApiOperation(value="字典新增", notes="用户字典修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysconfig", value = "字典", required = true, dataType = "sysConfig",paramType="body"),
    })
    @RequestMapping(value="addConfig", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysConfig:addConfig"})
    public String addConfig(@RequestBody sysConfig sysconfig) {
        int result=sysconfigservice.addConfig(sysconfig);
        if(result>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }

    @Override
    @ApiOperation(value="字典修改", notes="用户字典修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysconfig", value = "字典", required = true, dataType = "sysConfig",paramType="body"),
    })
    @RequestMapping(value="modifyConfig", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysConfig:modifyConfig"})
    public String modifyConfig(@RequestBody sysConfig sysconfig) {
        int result=sysconfigservice.modifyConfig(sysconfig);
        if(result>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }

    @Override
    @ApiOperation(value="字典删除", notes="用户字典删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "字典id", required = true, dataType = "String",paramType="path"),
    })
    @RequestMapping(value="deleteConfig/{id}", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysConfig:deleteConfig"})
    public String deleteConfig(@PathVariable String id) {
        int result=sysconfigservice.deleteConfig(id);
        if(result>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }

    @Override
    @ApiOperation(value="字典值查询", notes="字典值查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "字典key值", required = true, dataType = "String",paramType="path"),
            @ApiImplicitParam(name = "id", value = "字典id值", required = true, dataType = "String",paramType="path"),
    })
    @RequestMapping(value="getDicValue/{key}/{id}", method = RequestMethod.GET)
    @RequiresPermissions(value={"sysConfig:selectBykeyAndid"})
    public String selectBykeyAndid(@PathVariable String key, @PathVariable String id) {
        return JSON.toJSONString (new returnMsg(returnCode.SUCCESS,sysconfigservice.selectBykeyAndid(key,id)));
    }
}
