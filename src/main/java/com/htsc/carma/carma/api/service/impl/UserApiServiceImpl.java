package com.htsc.carma.carma.api.service.impl;

import com.htsc.carma.carma.api.service.UserApiService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 */
@Service
public class UserApiServiceImpl implements UserApiService {

    private static Logger logger= LoggerFactory.getLogger(UserApiServiceImpl.class);

    @Override
    public String queryUser() {
        String a="1234";
        logger.info("queryUser a="+a);
        return a;
    }

    @Override
    public List<String> queryAll() {
        List<String> list=new ArrayList<>();
        list.add("w");
        list.add("c");
        return list;
    }


}
