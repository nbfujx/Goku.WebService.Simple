package com.goku.webapi.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goku.webapi.mapper.ext.sysUserExtMapper;
import com.goku.webapi.model.sysUser;
import com.goku.webapi.service.sysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;


/**
 * Created by nbfujx on 2017/10/14.
 */
@Component
public class sysUserServiceImpl implements sysUserService {

    private Logger logger = LoggerFactory.getLogger(sysUserServiceImpl.class);

    @Autowired
    private sysUserExtMapper sysuserextmapper;

    @Override
    public sysUser selectByid(String id) {
        this.logger.info("selectByid");
        return sysuserextmapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo selectUserList(String username, String name, String status,
                                        String org_id, String is_admin,
                                        String orderFiled, String orderSort,
                                        int pageindex,int pagenum) {
        PageHelper.startPage(pageindex, pagenum);
        List<sysUser> list = sysuserextmapper.selectUserList(username, name, status, org_id, is_admin, orderFiled, orderSort);
        PageInfo page = new PageInfo(list);
        return page;
    }

    @Override
    public int addUser(sysUser sysuser) {
        return sysuserextmapper.insert(sysuser);
    }

    @Override
    public int modifyUser(sysUser sysuser) {
        return sysuserextmapper.updateByPrimaryKeySelective(sysuser);
    }

    @Override
    public int deleteUser(String id) {
        return sysuserextmapper.deleteByPrimaryKey(id);
    }

    @Override
    public int changeUserStatus(String id, String status) {
        return sysuserextmapper.changeUserStatus(id,status);
    }


}
