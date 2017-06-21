package com.dajia.web.controller;

import com.dajia.service.Demo2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chengboying on 2017/6/19.
 */
@Controller
@RequestMapping("/demo2")

public class Demo2Controller {

    @Autowired
    private Demo2Service demo2Service;

    @RequestMapping("/hello/{message}")
    public String getHello(Map<String, Object> model, @PathVariable String message) throws Exception {
        model.put("time", new Date());
        model.put("message", message + " !!");
        return "demo/hello";
    }

    @RequestMapping("/word/{person}")
    public String get(Map<String, Object> model, @PathVariable String person) throws Exception {
        String str = demo2Service.getHello(person);
        model.put("word", str);
        return "demo/word";
    }

    /**
     * 1.直接把表单的参数写在Controller相应的方法的形参中
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/addUser1")
    @ResponseBody
    public String addUser1(String username,String password) {
        System.out.println("username is:"+username);
        System.out.println("password is:"+password);
        return username + " " + password;

    }

    /**
     * 2、通过HttpServletRequest接收
     * @return
     */
    @RequestMapping("/addUser2")
    @ResponseBody
    public String addUser2(@RequestParam(value = "username") String us, @RequestParam(value = "password") String pwd) {
//        String username=request.getParameter("usename");
//        String password=request.getParameter("password");
        System.out.println("username is:"+us);
        System.out.println("password is:"+pwd);
        return us + " " + pwd;
    }

    @RequestMapping("/addUser3")
    @ResponseBody
    public String addUser3() {
        return "hello";
    }
//post请求
    @RequestMapping(value = "/addUser4", method = RequestMethod.POST)
    @ResponseBody
    public String addUser4() {
        System.out.println("hello  test post");
        return "ok";
    }





}
