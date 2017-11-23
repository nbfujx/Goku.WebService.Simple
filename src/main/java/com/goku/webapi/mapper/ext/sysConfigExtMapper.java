package com.goku.webapi.mapper.ext;

import com.goku.webapi.mapper.sysConfigMapper;
import com.goku.webapi.model.sysConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by nbfujx on 2017-11-23.
 */
public interface sysConfigExtMapper extends sysConfigMapper {
    List<sysConfig> selectConfigList(@Param("remark") String remark, @Param("orderFiled")  String orderFiled, @Param("orderSort") String orderSort);
    sysConfig selectByKey(@Param("key")  String key);
}
