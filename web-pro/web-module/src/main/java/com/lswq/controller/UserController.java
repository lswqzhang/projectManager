package com.lswq.controller;

import com.lswq.service.UserService;
import com.lswq.service.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
    @Autowired  
    private UserService userService;  
      
    @RequestMapping(value = "/showUserInfo", method = RequestMethod.GET)    
    public ModelAndView getIndex(){      
        ModelAndView mav = new ModelAndView("index");   
        User user = userService.selectUserById(1);  
        mav.addObject("user", user);
        System.err.println(this.toString() + "" + Thread.currentThread().getName());
        return mav;    
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserInfo(){
        User user = userService.selectUserById(1);
        System.err.println(this.toString() + "" + Thread.currentThread().getName());
        return user;
    }
}
