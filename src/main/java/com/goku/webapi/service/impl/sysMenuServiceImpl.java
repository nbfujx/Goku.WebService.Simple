package com.goku.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goku.webapi.mapper.ext.sysMenuExtMapper;
import com.goku.webapi.model.sysMenu;
import com.goku.webapi.service.sysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by nbfujx on 2017/11/7.
 */
@Component
public class sysMenuServiceImpl implements sysMenuService {

    @Autowired
    private sysMenuExtMapper sysmenumapper;

    @Override
    public sysMenu selectByid(String id) {
        return  sysmenumapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo selectMenuList(String name, String type, String module_id, String orderFiled, String orderSort,int pageindex,int pagenum) {
        PageHelper.startPage(pageindex, pagenum);
        List<sysMenu> list = sysmenumapper.selectMenuList(name, type, module_id, orderFiled, orderSort);
        PageInfo page = new PageInfo(list);
        return page;
    }

    @Override
    public int addMenu(sysMenu symenu) {
        return sysmenumapper.insert(symenu);
    }

    @Override
    public int modifyMenu(sysMenu symenu) {
        return sysmenumapper.updateByPrimaryKey(symenu);
    }

    @Override
    public int deleteMenu(String id) {
        return sysmenumapper.deleteByPrimaryKey(id);
    }
}
