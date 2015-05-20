package com.springapp.mvc.controller;

/**
 * Created by Arthur's Notebook on 5/15/2015.
 */
import com.springapp.mvc.model.User;
import com.springapp.mvc.dao.UserDAO;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Controller
public class UserController {

    //Get the Spring Context
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    //Get the UserDAO Bean
    UserDAO userDAO = ctx.getBean("userDAO", UserDAO.class);

    //InitBinder in controller for spring to convert date string to java.util.Date object
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }


    @RequestMapping(value ={"/getAllUsers", "/"}, method = RequestMethod.GET)
    public ModelAndView getAllUsers() {
        long count = userDAO.getCount();
        return new ModelAndView("ViewList", "itemCount", count);
    }

    @RequestMapping(value = "/getAll/{val}", method = {RequestMethod.POST})
    public @ResponseBody  List<User> getAllUserss( @PathVariable long val) {
        List<User> userList = userDAO.getAll(val);
        return userList;
    }

    @RequestMapping(value = "createUser", method = RequestMethod.GET)
    public ModelAndView createUser(@ModelAttribute User user) {

        return new ModelAndView("createForm");
    }

    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable  long id, @ModelAttribute User user) {

        user = userDAO.getById(id);
        return new ModelAndView("editForm", "userObject", user);

    }

    @RequestMapping("saveUser")
    public ModelAndView saveUser(@ModelAttribute User user) {
        if(user.getId() == 0){ // if User id is 0 then creating the user other updating the user
            user.setCreatedDate(new Date());
            user.setModifiedDate(new Date());
            userDAO.create(user);
        } else {
            user.setModifiedDate(new Date());
            userDAO.update(user);
        }
        return new ModelAndView("redirect:getAllUsers");
    }

    @RequestMapping("deleteUser")
    public ModelAndView deleteUser(@RequestParam long id) {
        userDAO.deleteById(id);
        return new ModelAndView("redirect:getAllUsers");
    }
}
