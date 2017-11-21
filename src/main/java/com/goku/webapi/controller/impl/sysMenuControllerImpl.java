package com.goku.webapi.controller.impl;

import com.alibaba.fastjson.JSON;
import com.goku.webapi.controller.sysMenuController;
import com.goku.webapi.model.sysMenu;
import com.goku.webapi.service.sysMenuService;
import com.goku.webapi.service.sysUserService;
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
 * Created by nbfujx on 2017/11/7.
 */
@RestController
@RequestMapping("sysMenu")
@Api(value="菜单管理")
public class sysMenuControllerImpl implements sysMenuController {

    @Autowired
    sysMenuService sysmenuService;

    @Override
    @RequestMapping(value="getMenu/{id}", method = RequestMethod.GET)
    @RequiresPermissions(value={"sysMenu:selectByid"})
    @ApiOperation(value="菜单查询", notes="菜单信息查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "菜单id", required = true, dataType = "String",paramType="path"),
    })
    public String  selectMenuByid(@PathVariable String id) {
        return JSON.toJSONString (new returnMsg(returnCode.SUCCESS,sysmenuService.selectByid(id)));
    }

    @Override
    @ApiOperation(value="菜单查询", notes="菜单列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "菜单名称", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "type", value = "菜单类别", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "module_id", value = "模块id", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "orderFiled", value = "", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "orderSort", value = "", dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "pageindex", value = "当前页", dataType = "int",paramType="query"),
            @ApiImplicitParam(name = "pagenum", value = "页大小", dataType = "int",paramType="query"),
    })
    @RequestMapping(value="getMenuList", method = RequestMethod.GET)
    @RequiresPermissions(value={"sysMenu:getMenuList"})
    public String selectMenuList(@RequestParam(required=false) String name,@RequestParam(required=false)  String type,@RequestParam(required=false)  String module_id,
                                  @RequestParam(required=false) String orderFiled, @RequestParam(required=false) String orderSort,
                                  @RequestParam  int pageindex, @RequestParam int pagenum) {
          return JSON.toJSONString (new returnMsg(returnCode.SUCCESS,
                sysmenuService.selectMenuList(name,type,module_id,orderFiled,orderSort,pageindex,pagenum)));
    }

    @Override
    @ApiOperation(value="菜单新增", notes="用户菜单修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "symenu", value = "菜单", required = true, dataType = "sysMenu",paramType="body"),
    })
    @RequestMapping(value="addMenu", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysMenu:addMenu"})
    public String addMenu(@RequestBody  sysMenu symenu) {
        int result=sysmenuService.addMenu(symenu);
        if(result>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }

    @Override
    @ApiOperation(value="菜单修改", notes="用户菜单修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "symenu", value = "菜单", required = true, dataType = "sysMenu",paramType="body"),
    })
    @RequestMapping(value="modifyMenu", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysMenu:modifyMenu"})
    public String modifyMenu(@RequestBody sysMenu symenu) {
        int result=sysmenuService.modifyMenu(symenu);
        if(result>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }

    @Override
    @ApiOperation(value="菜单删除", notes="用户菜单删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "菜单id", required = true, dataType = "String",paramType="path"),
    })
    @RequestMapping(value="deleteMenu/{id}", method = RequestMethod.POST)
    @RequiresPermissions(value={"sysMenu:deleteMenu"})
    public String deleteMenu(@PathVariable  String id) {
        int result=sysmenuService.deleteMenu(id);
        if(result>0) {
            return JSON.toJSONString (new returnMsg(returnCode.SUCCESS));
        }else{
            return JSON.toJSONString (new returnMsg(returnCode.ERROR));
        }
    }
}
