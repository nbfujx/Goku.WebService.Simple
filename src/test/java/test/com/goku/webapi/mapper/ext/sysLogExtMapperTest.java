package test.com.goku.webapi.mapper.ext;

import com.alibaba.fastjson.JSON;
import com.goku.webapi.WebapiApplication;
import com.goku.webapi.mapper.ext.sysLogExtMapper;
import com.goku.webapi.model.sysLog;
import com.goku.webapi.model.sysMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nbfujx on 2017-11-22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebapiApplication.class)
public class sysLogExtMapperTest {

    @Autowired
    sysLogExtMapper syslogmapper;

    @Test
    public void selectLogList() throws Exception {
        List<sysLog> sysmenu=syslogmapper.selectLogList("nbfujx",null,null,null,null);
        System.out.print( JSON.toJSONString (sysmenu));
    }

}