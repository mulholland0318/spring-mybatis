package com.mdachu.controller;

/**
 * Created by mm on 2017/5/6.
 */

import com.mdachu.entity.User;
import com.mdachu.mapper.UserMapper;
import com.mdachu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Resource(name="userService")
    private UserService service;


    @RequestMapping("/list")
    @ResponseBody
    public Object listUsers(){
        //List<User> user =
        System.out.println("listaction");
        return "abdc";
    }

    @RequestMapping(value = "/listAllUser",method = RequestMethod.GET)
    public ModelAndView listAllUser(){
        ModelAndView mv = new ModelAndView();
        System.out.println("listAllUser");
        mv.setViewName("users");
        mv.addObject("userName","allUser");
        return mv;
    }

}
