package com.goku.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goku.webapi.mapper.ext.sysOrgExtMapper;
import com.goku.webapi.model.sysOrg;
import com.goku.webapi.service.sysOrgService;
import com.goku.webapi.util.treehelper.TreeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by nbfujx on 2017-11-22.
 */
@Component
public class sysOrgServiceImpl implements sysOrgService {

    @Autowired
    sysOrgExtMapper sysorgmapper;

    @Override
    public sysOrg selectByid(String id) {
        return sysorgmapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo selectOrgList(String parent_id, String orderFiled, String orderSort, int pageindex, int pagenum) {
        PageHelper.startPage(pageindex, pagenum);
        List<sysOrg> list = sysorgmapper.selectOrgList(parent_id, orderFiled, orderSort);
        PageInfo page = new PageInfo(list);
        return page;
    }

    @Override
    public TreeInfo selectOrgTree() {
        return null;
    }

    @Override
    public int addOrg(sysOrg sysorg) {
        return sysorgmapper.insert(sysorg);
    }

    @Override
    public int modifyOrg(sysOrg sysorg) {
        return sysorgmapper.updateByPrimaryKeySelective(sysorg);
    }

    @Override
    public int deleteOrg(String id) {
        return sysorgmapper.deleteByPrimaryKey(id);
    }
}
