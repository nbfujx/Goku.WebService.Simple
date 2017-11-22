package com.goku.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goku.webapi.mapper.ext.sysModuleExtMapper;
import com.goku.webapi.model.sysModule;
import com.goku.webapi.service.sysModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by nbfujx on 2017-11-22.
 */
@Component
public class sysModuleServiceImpl implements sysModuleService {

    @Autowired
    sysModuleExtMapper sysmodulemapper;

    @Override
    public sysModule selectByid(String id) {
        return sysmodulemapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo selectModuleList(String name, String orderFiled, String orderSort, int pageindex, int pagenum) {
        PageHelper.startPage(pageindex, pagenum);
        List<sysModule> list = sysmodulemapper.selectModuleList(name, orderFiled, orderSort);
        PageInfo page = new PageInfo(list);
        return page;
    }

    @Override
    public int addModule(sysModule sysmodule) {
        return sysmodulemapper.insert(sysmodule);
    }

    @Override
    public int modifyModule(sysModule sysmodule) {
        return sysmodulemapper.updateByPrimaryKeySelective(sysmodule);
    }

    @Override
    public int deleteModule(String id) {
        return sysmodulemapper.deleteByPrimaryKey(id);
    }
}
