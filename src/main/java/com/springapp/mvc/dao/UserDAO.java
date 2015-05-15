package com.springapp.mvc.dao;

/**
 * Created by Arthur's Notebook on 5/14/2015.
 */

import com.springapp.mvc.model.User;
import java.util.List;

public interface UserDAO {
    //Create User
    public void create(User user);

    //Get User by ID
    public User getById(long id);

    //Update User
    public void update(User user);

    //Delete User by ID
    public void deleteById(long id);

    //Get All Users
    public List<User> getAll();

    //Get Missing Records
    //public List<User> getMissings();
}
