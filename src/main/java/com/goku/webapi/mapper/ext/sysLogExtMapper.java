package com.goku.webapi.mapper.ext;

import com.goku.webapi.mapper.sysLogMapper;
import com.goku.webapi.model.sysLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by nbfujx on 2017-11-22.
 */
public interface sysLogExtMapper extends sysLogMapper {
    List<sysLog> selectLogList(@Param("username") String username, @Param("startTime") String startTime,@Param("endTime") String endTime,
                               @Param("orderFiled")  String orderFiled, @Param("orderSort") String orderSort);
}
