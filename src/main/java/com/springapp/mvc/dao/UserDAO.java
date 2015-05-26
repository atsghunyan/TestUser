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
    public User getById(int id);

    //Update User
    public void update(User user);

    //Delete User by ID
    public void deleteById(int id);

    //Get All Users
    public List<User> getAll(int i, int j);

    //Get Total Users Count
    public int getCount();

    // Get Missing records
    public String getMissings();



}
