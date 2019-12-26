package com.htsc.carma.carma.api.service;

import com.htsc.carma.carma.dao.User;
import com.htsc.carma.carma.myanotation.MyValidate;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserApiServiceTest {

    @Autowired
    private UserApiService userApiService;

    private static Logger logger= LoggerFactory.getLogger(UserApiServiceTest.class);

    @Test
    void queryUser() {
        String s = this.userApiService.queryUser();
        System.out.println("s = " + s);
        logger.info("Hello");
        logger.error("World");
    }
    @Test
    void queryAll() {
        List<String> list = this.userApiService.queryAll();
        System.out.println("list = " + list);
    }

    @Test
    public void test() {
        User user=new User();
        try {
            MyValidate.validator(user);
        } catch (Exception e) {
            logger.error(""+e);
        }
        System.out.println("user = " + user);
    }
}