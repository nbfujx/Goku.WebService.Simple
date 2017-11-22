package com.goku.webapi.mapper.ext;

import com.goku.webapi.mapper.sysOrgMapper;
import com.goku.webapi.model.sysOrg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by nbfujx on 2017-11-22.
 */
public interface sysOrgExtMapper extends sysOrgMapper {
    List<sysOrg> selectOrgList(@Param("parent_id")  String parent_id,@Param("orderFiled")  String orderFiled, @Param("orderSort") String orderSort);
}
