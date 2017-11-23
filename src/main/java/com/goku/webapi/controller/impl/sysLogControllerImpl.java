package com.goku.webapi.controller.impl;

import com.alibaba.fastjson.JSON;
import com.goku.webapi.controller.sysLogController;
import com.goku.webapi.service.sysLogService;
import com.goku.webapi.util.enums.returnCode;
import com.goku.webapi.util.message.returnMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nbfujx on 2017-11-22.
 */
@RestController
@RequestMapping("sysLog")
@Api(value="日志管理")
public class sysLogControllerImpl implements sysLogController {


    @Autowired
    sysLogService syslogservice;

    @Override
    @ApiOperation(value="日志查询", notes="日志列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "startTime", value = "开始时间", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "orderFiled", value = "", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "orderSort", value = "", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "pageindex", value = "当前页", dataType = "int",paramType="query"),
            @ApiImplicitParam(name = "pagenum", value = "页大小", dataType = "int",paramType="query"),
    })
    @RequestMapping(value="getLogList", method = RequestMethod.GET)
    @RequiresPermissions(value={"sysLog:selectLogList"})
    public String selectLogList(@RequestParam(required=false) String username, @RequestParam(required=false) String startTime, @RequestParam(required=false) String endTime,
                                 @RequestParam(required=false) String orderFiled, @RequestParam(required=false) String orderSort,
                                 @RequestParam int pageindex, @RequestParam int pagenum) {
        return JSON.toJSONString (new returnMsg(returnCode.SUCCESS,
                syslogservice.selectLogList(username, startTime, endTime, orderFiled, orderSort,pageindex,pagenum)));
    }
}
