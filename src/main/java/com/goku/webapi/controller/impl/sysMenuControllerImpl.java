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
    public String selectMenuList(@RequestParam(required=false) String name,@RequestParam(required=false)  String type,@RequestParam(required=false)  String module_id,
                                  @RequestParam(required=false) String orderFiled, @RequestParam(required=false) String orderSort,
                                  @RequestParam  int pageindex, @RequestParam int pagenum) {
        return null;
    }

    @Override
    public String addMenu(sysMenu symenu) {
        return null;
    }

    @Override
    public String modifyMenu(sysMenu symenu) {
        return null;
    }

    @Override
    public String deleteMenu(String id) {
        return null;
    }
}
