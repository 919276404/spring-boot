package com.dajia.web.controller;

import com.dajia.service.DemoService;
import com.seeyon.framework.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by dengq on 2017/6/12.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/hello/{message}")
    public String getHello(Map<String, Object> model, @PathVariable String message) throws Exception {
        model.put("time", new Date());
        model.put("message", message + " !!");
        return "demo/hello";
    }

    @RequestMapping("/word/{person}")
    public String get(Map<String, Object> model, @PathVariable String person) throws Exception {
        String str = demoService.getHello(person);
        model.put("word", str);
        return "demo/word";
    }
}
