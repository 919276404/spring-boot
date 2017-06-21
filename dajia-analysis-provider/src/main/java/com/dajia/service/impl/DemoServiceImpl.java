package com.dajia.service.impl;

import com.dajia.service.DemoService;
import com.seeyon.framework.exception.BaseException;
import org.springframework.stereotype.Service;

/**
 * Created by dengq on 2017/6/12.
 */

@Service("demoService")
public class DemoServiceImpl implements DemoService {

    @Override
    public String getHello(String person) throws BaseException {
        return "hello " + person;
    }
}
