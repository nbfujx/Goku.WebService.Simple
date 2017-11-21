package com.goku.webapi.mapper.ext;

import com.goku.webapi.mapper.sysRoleMapper;
import com.goku.webapi.model.sysRole;

import java.util.List;

/**
 * Created by nbfujx on 2017-11-21.
 */
public interface sysRoleExtMapper extends sysRoleMapper {
    List<sysRole> selectRoleList(String orderFiled, String orderSort);
}
