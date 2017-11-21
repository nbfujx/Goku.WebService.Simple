package test.com.goku.webapi.mapper.ext;

import com.alibaba.fastjson.JSON;
import com.goku.webapi.WebapiApplication;
import com.goku.webapi.mapper.ext.sysUserExtMapper;
import com.goku.webapi.model.sysUser;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nbfujx on 2017-11-07.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebapiApplication.class)
public class sysUserExtMapperTest {





    @Autowired
    sysUserExtMapper sysuserextmapper;

    @Test
    public void selectByUsername() throws Exception {
        sysUser sysuser=sysuserextmapper.selectByUsername("nbfujx");
        System.out.print( JSON.toJSONString (sysuser));
    }

    @Test
    public void selectUserList() throws Exception {
        List<sysUser> sysuser=sysuserextmapper.selectUserList("nbfujx",null,null,null,null,null,null);
        System.out.print( JSON.toJSONString (sysuser));
    }

    @Test
    public void getpassword() throws Exception {
        String str = "123";
        String salt = "2";
        String md5 = new Md5Hash(str, salt).toString();
        System.out.print(md5);
    }

    @Test
    public void changeUserStatus() throws Exception {
       int i= sysuserextmapper.changeUserStatus("1","1");
        System.out.print(i);
    }
}