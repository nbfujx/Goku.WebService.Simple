package com.goku.webapi.controller;

import com.goku.webapi.config.log.LoggerInfo;

/**
 * Created by nbfujx on 2017-11-22.
 */
public interface sysLogController {
    @LoggerInfo(Method = "selectLogList",Name = "查询日志")
    String selectLogList(String username, String startTime, String endTime, String orderFiled, String orderSort, int pageindex, int pagenum);
}
