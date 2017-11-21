package test.com.goku.webapi.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.goku.webapi.WebapiApplication;
import com.goku.webapi.mapper.ext.sysUserExtMapper;
import com.goku.webapi.model.sysUser;
import com.goku.webapi.service.sysUserService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nbfujx on 2017-11-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebapiApplication.class)
public class sysUserServiceImplTest{

    @Autowired
    sysUserService sysuserservice;

    @Test
    public void selectUserList() throws Exception {
        PageInfo sysuser=sysuserservice.selectUserList("nbfujx",null,null,null,null,null,null,1,10);
        System.out.print( JSON.toJSONString (sysuser));
    }

}