package test.com.goku.webapi.service.impl;

import com.goku.webapi.WebapiApplication;
import com.goku.webapi.service.sysConfigService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by nbfujx on 2017-11-23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebapiApplication.class)
public class sysConfigServiceImplTest  {


    @Autowired
    sysConfigService sysconfigservice;

    @Test
    public void selectBykeyAndid() throws Exception {
        System.out.print(sysconfigservice.selectBykeyAndid("sex","1"));
    }

}