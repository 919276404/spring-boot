package com.dajia.service.impl;

import com.dajia.service.DemoService;
import com.dajia.service.UserService;
import com.seeyon.framework.exception.BaseException;
import org.springframework.stereotype.Service;

/**
 *
 */

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public String  deleteUser(Long id) throws Exception {
        return id + "删除成功";
    }

}
