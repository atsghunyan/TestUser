package com.springapp.mvc.controller;

/**
 * Created by Arthur's Notebook on 5/15/2015.
 */
import com.springapp.mvc.model.User;
import com.springapp.mvc.dao.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Controller
public class UserController {

    //Get the Spring Context
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    //Get the EmployeeDAO Bean
    UserDAO userDAO = ctx.getBean("userDAO", UserDAO.class);

    @RequestMapping(value ={"/getAllUsers/", "/"}, method = RequestMethod.GET)
    public ModelAndView getAllUsers() {
        long count = userDAO.getCount();
        return new ModelAndView("ViewList", "itemCount", count);
    }

    @RequestMapping(value = "/getAll/{val}", method = {RequestMethod.POST})
    public @ResponseBody  List<User> getAllUserss( @PathVariable long val) {
        List<User> userList = userDAO.getAll(val);
        return userList;
    }
}
