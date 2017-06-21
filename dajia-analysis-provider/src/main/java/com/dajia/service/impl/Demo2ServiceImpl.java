package com.dajia.service.impl;

import com.dajia.service.Demo2Service;
import com.dajia.service.DemoService;
import com.seeyon.framework.exception.BaseException;
import org.springframework.stereotype.Service;

/**
 * Created by chengboying on 2017/6/19.
 */

@Service("demo2Service")
public class Demo2ServiceImpl implements Demo2Service {

    @Override
    public String getHello(String person) throws BaseException {
        return "hello " + person;
    }
}

