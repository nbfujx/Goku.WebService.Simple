package com.goku.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goku.webapi.mapper.ext.sysConfigExtMapper;
import com.goku.webapi.model.sysConfig;
import com.goku.webapi.service.sysConfigService;
import com.goku.webapi.util.dichelper.DicInfo;
import com.goku.webapi.util.dichelper.Json2DicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by nbfujx on 2017-11-23.
 */
@Component
public class sysConfigServiceImpl implements sysConfigService {

    @Autowired
    sysConfigExtMapper sysconfigmapper;

    @Override
    public PageInfo selectConfigList(String remark, String orderFiled, String orderSort, int pageindex, int pagenum) {
        PageHelper.startPage(pageindex, pagenum);
        List<sysConfig> list = sysconfigmapper.selectConfigList(remark, orderFiled, orderSort);
        PageInfo page = new PageInfo(list);
        return page;
    }

    @Override
    public sysConfig selectByid(String id) {
        return sysconfigmapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DicInfo> selectByKey(String key) {
        sysConfig sysconfig= sysconfigmapper.selectByKey(key);
        List<DicInfo> list= Json2DicInfo.jsonToDicInfo(sysconfig.getValue());
        return list;
    }

    @Override
    public int addConfig(sysConfig sysconfig) {
        return sysconfigmapper.insert(sysconfig);
    }

    @Override
    public int modifyConfig(sysConfig sysconfig) {
        return sysconfigmapper.updateByPrimaryKeySelective(sysconfig);
    }

    @Override
    public int deleteConfig(String id) {
        return sysconfigmapper.deleteByPrimaryKey(id);
    }

    @Override
    public DicInfo selectBykeyAndid(String key, String id) {
        sysConfig sysconfig=sysconfigmapper.selectByKey(key);
        List<DicInfo> list= Json2DicInfo.jsonToDicInfo(sysconfig.getValue());
        DicInfo dic=null;
        for(DicInfo di:list)
        {
            if(id.equals(di.getId()))
            {
                dic=di;
                break;
            }
        }
        return dic;
    }
}
