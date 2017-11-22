package com.goku.webapi.controller;

/**
 * Created by nbfujx on 2017-11-22.
 */
public interface sysLogController {
    String selectLogList(String username, String startTime, String endTime, String orderFiled, String orderSort, int pageindex, int pagenum);
}
