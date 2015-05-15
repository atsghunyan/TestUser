package com.springapp.mvc.dao;

/**
 * Created by Arthur's Notebook on 5/14/2015.
 */

import com.springapp.mvc.model.User;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class UserDAOImpl implements UserDAO {

    private DataSource dataSource;
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    //  Create a User
    @Override
    public void create(User user) {
        String query = "insert into TestUser (id, name,created_date, modified_date) values (?,?,?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        Object[] args = new Object[] {user.getId(), user.getName(), user.getCreatedDate(), user.getModifiedDate()};

        int out = jdbcTemplate.update(query, args);

        if(out !=0){
            System.out.println("User saved with id="+user.getId());
        }else System.out.println("User save failed with id="+user.getId());
    }

    //  Get User by ID
    @Override
    public User getById(long id) {
        String query = "select id, name, created_date, modified_date from TestUser where id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //using  anonymous class RowMapper
        User emp = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<User>(){

            @Override
            public User mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                User emp = new User();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setCreatedDate(rs.getDate("created_date"));
                emp.setModifiedDate(rs.getDate("modified_date"));

                return emp;
            }});

        return emp;
    }

    // Update User
    @Override
    public void update(User user) {
        String query = "update TestUser set name=?, created_date=?, modified_date=? where id=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = new Object[] {user.getName(), user.getCreatedDate(), user.getModifiedDate(), user.getId()};

        int out = jdbcTemplate.update(query, args);
        if(out !=0){
            System.out.println("Employee updated with id="+user.getId());
        }else System.out.println("No Employee found with id="+user.getId());
    }

    // Delete User by ID
    @Override
    public void deleteById(long id) {

        String query = "delete from TestUser where id=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        int out = jdbcTemplate.update(query, id);
        if(out !=0){
            System.out.println("User deleted with id="+id);
        }else System.out.println("No User found with id="+id);
    }


    //Get All Users List
    @Override
    public List<User> getAll() {
        String query = "select id, name, created_date, modified_date from TestUser";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<User> userList = new ArrayList<User>();

        List<Map<String,Object>> userRows = jdbcTemplate.queryForList(query);

        for(Map<String,Object> userRow : userRows){
            User user = new User();
            user.setId(Long.parseLong(String.valueOf(userRow.get("id"))));
            user.setName(String.valueOf(userRow.get("name")));
            user.setCreatedDate(Date.valueOf(String.valueOf(userRow.get("created_date"))));
            user.setModifiedDate(Date.valueOf(String.valueOf(userRow.get("modified_date"))));

            userList.add(user);
        }
        return userList;
    }


}
