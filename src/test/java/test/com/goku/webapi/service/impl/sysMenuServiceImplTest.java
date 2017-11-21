package test.com.goku.webapi.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.goku.webapi.WebapiApplication;
import com.goku.webapi.service.sysMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by nbfujx on 2017-11-21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebapiApplication.class)
public class sysMenuServiceImplTest  {

    @Autowired
    sysMenuService sysmenuservice;

    @Test
    public void selectMenuList() throws Exception {
        PageInfo sysmenu=sysmenuservice.selectMenuList("2",null,null,null,null,1,10);
        System.out.print( JSON.toJSONString (sysmenu));
    }

}