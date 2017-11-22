package com.goku.webapi.service;

import com.github.pagehelper.PageInfo;
import com.goku.webapi.model.sysLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by nbfujx on 2017-11-22.
 */
public interface sysLogService {
    PageInfo selectLogList(String username, String startTime, String endTime, String orderFiled, String orderSort, int pageindex, int pagenum);
}
