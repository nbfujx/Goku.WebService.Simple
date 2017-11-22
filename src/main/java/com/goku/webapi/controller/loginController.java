package com.goku.webapi.controller;

import com.goku.webapi.config.log.LoggerInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nbfujx on 2017-11-07.
 */
public interface loginController {
    @LoggerInfo(Method = "login",Name = "登录")
    String login(String userName, String password,boolean rememberMe);
    @LoggerInfo(Method = "logout",Name = "登出")
    String logout();
    String notAuthc();
    String notAuthz();
    String error(HttpServletRequest request);
}
