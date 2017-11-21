package com.goku.webapi.mapper.ext;

import com.goku.webapi.mapper.sysMenuMapper;
import com.goku.webapi.model.sysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by nbfujx on 2017-11-07.
 */
public interface sysMenuExtMapper extends sysMenuMapper {
    /**
    * @Author:nbfujx
    * @Param:
    * @param id  用户id
    * @Date: 13:44 2017-11-13
    */
    List<sysMenu> selectMenuByUserId(@Param("id") String id);

    /**
    * @Author:nbfujx
    * @Param:
    * @param name  菜单名
     * @param type 菜单类别
     * @param module_id  模块id
    * @Date: 13:20 2017-11-21
    */
    List<sysMenu>  selectMenuList(@Param("name") String name,@Param("type") String type,@Param("module_id") String module_id,
                           @Param("orderFiled") String orderFiled,@Param("orderSort") String orderSort);

}
