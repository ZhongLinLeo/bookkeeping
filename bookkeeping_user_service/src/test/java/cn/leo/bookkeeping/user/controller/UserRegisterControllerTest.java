package cn.leo.bookkeeping.user.controller;


import cn.leo.bookkeeping.user.common.uid.UidGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author leo.zl on 2020/6/3
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class UserRegisterControllerTest {

    @Resource(name = "defaultUidGenerator")
    private UidGenerator uidGenerator;

    @Test
    public void test(){
        System.out.println(uidGenerator.getUID());
    }


    @Test
    public void test1(){
        System.out.println(System.currentTimeMillis());
    }


}