package com.dajia.web.controller;

import com.dajia.entity.User;
import com.dajia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by chengboying on 2017/6/20.
 */
@Controller
@RequestMapping("/http")
public class HttpTestController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/map.json", method = {RequestMethod.GET,})
    @ResponseBody
    public Map map(){
        Map map = new HashMap();
        map.put("name","cbhengboying");
        map.put("sex","man");
        map.put("age",22);
        List list = new ArrayList();
        list.add("red");
        list.add("black");
        list.add("blue");
        list.add("yellow");
        map.put("colors",list);
        return map;
    }


@RequestMapping(value = "post",method = RequestMethod.POST)
@ResponseBody
public User post( @RequestBody User user){
        return user;
}

    @RequestMapping(value = "put",method = RequestMethod.PUT)
    @ResponseBody
    public User put( @RequestBody User user){
        return user;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") Long id) throws Exception{
        String result = userService.deleteUser(id);
        System.out.println(result + "service");
        return "删除了"+ id;
    }
}
