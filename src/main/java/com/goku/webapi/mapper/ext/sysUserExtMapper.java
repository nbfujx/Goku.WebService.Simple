package com.goku.webapi.mapper.ext;

import com.goku.webapi.mapper.sysUserMapper;
import com.goku.webapi.model.sysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by nbfujx on 2017/10/14.
 */
public interface sysUserExtMapper extends sysUserMapper {
    /**
    * @Author:nbfujx
    * @Param:
    * @param username  用户名
    * @Date: 13:45 2017-11-13
    */
    sysUser selectByUsername(@Param("username") String username);

    /**
    * @Author:nbfujx
    * @Param:
    * @param username 用户名
     *@param name 姓名
     *@param status 用户状态
     *@param org_id 用户部门
     *@param is_admin 是否管理员
    * @Date: 14:52 2017-11-20
    */ 
    List<sysUser> selectUserList(@Param("username")String username, @Param("name") String name,
                                 @Param("status") String status, @Param("org_id")String org_id, @Param("is_admin") String is_admin,
                                 @Param("orderFiled") String orderFiled, @Param("orderSort") String orderSort);


    /**
    * @Author:nbfujx
    * @Param:
     * @param id 用户id
     * @param status 用户状态
    * @Date: 16:44 2017-11-20
    */
    int changeUserStatus(@Param("id") String id,@Param("status") String status);

}
