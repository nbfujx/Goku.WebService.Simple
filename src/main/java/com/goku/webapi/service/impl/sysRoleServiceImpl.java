package com.goku.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goku.webapi.mapper.ext.sysRoleExtMapper;
import com.goku.webapi.model.sysRole;
import com.goku.webapi.service.sysRoleService;
import com.goku.webapi.util.treehelper.TreeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by nbfujx on 2017-11-21.
 */
@Component
public class sysRoleServiceImpl implements sysRoleService {

    @Autowired
    sysRoleExtMapper sysroleextmapper;

    @Override
    public sysRole selectByid(String id) {
        return sysroleextmapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo selectRoleList(String orderFiled, String orderSort, int pageindex, int pagenum) {
        PageHelper.startPage(pageindex, pagenum);
        List<sysRole> list = sysroleextmapper.selectRoleList(orderFiled, orderSort);
        PageInfo page = new PageInfo(list);
        return page;
    }

    @Override
    public TreeInfo selectRoleTree() {
        return null;
    }

    @Override
    public int addRole(sysRole sysrole) {
        return sysroleextmapper.insert(sysrole);
    }

    @Override
    public int modifyRole(sysRole sysrole) {
        return sysroleextmapper.updateByPrimaryKeySelective(sysrole);
    }

    @Override
    public int deleteRole(String id) {
        return sysroleextmapper.deleteByPrimaryKey(id);
    }
}
