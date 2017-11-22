package com.goku.webapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goku.webapi.mapper.ext.sysLogExtMapper;
import com.goku.webapi.model.sysLog;
import com.goku.webapi.model.sysMenu;
import com.goku.webapi.service.sysLogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by nbfujx on 2017-11-22.
 */
public class sysLogServiceImpl implements sysLogService {

    @Autowired
    sysLogExtMapper syslogmapper;

    @Override
    public PageInfo selectLogList(String username, String startTime, String endTime, String orderFiled, String orderSort, int pageindex, int pagenum) {
        PageHelper.startPage(pageindex, pagenum);
        List<sysLog> list = syslogmapper.selectLogList(username, startTime, endTime, orderFiled, orderSort);
        PageInfo page = new PageInfo(list);
        return page;
    }
}
