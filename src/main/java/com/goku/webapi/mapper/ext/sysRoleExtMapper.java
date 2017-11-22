package com.goku.webapi.mapper.ext;

import com.goku.webapi.mapper.sysRoleMapper;
import com.goku.webapi.model.sysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by nbfujx on 2017-11-21.
 */
public interface sysRoleExtMapper extends sysRoleMapper {
    List<sysRole> selectRoleList(@Param("orderFiled")  String orderFiled, @Param("orderSort") String orderSort);
}
