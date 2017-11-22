package com.goku.webapi.mapper.ext;

import com.goku.webapi.mapper.sysModuleMapper;
import com.goku.webapi.model.sysModule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by nbfujx on 2017-11-22.
 */
public interface sysModuleExtMapper extends sysModuleMapper {
    List<sysModule> selectModuleList(@Param("name")  String name,@Param("orderFiled")  String orderFiled, @Param("orderSort") String orderSort);
}
