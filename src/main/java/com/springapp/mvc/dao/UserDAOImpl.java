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

    // Table Name
    private final String TableName = "TestUser";

    //itemsOnPage
    public int itemsOnPage = 3;

    private DataSource dataSource;
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }


    //  Create a User
    @Override
    public void create(User user) {
        String query = "insert into "+TableName+" (id, name,created_date, modified_date) values (?,?,?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = new Object[] {user.getId(), user.getName(), user.getCreatedDate(), user.getModifiedDate()};
        int out = jdbcTemplate.update(query, args);
    }


    //  Get User by ID
    @Override
    public User getById(long id) {
        String query = "select id, name, created_date, modified_date from "+TableName+" where id = ?";
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
        String query = "update "+TableName+" set name=?, created_date=?, modified_date=? where id=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] args = new Object[] {user.getName(), user.getCreatedDate(), user.getModifiedDate(), user.getId()};

        int out = jdbcTemplate.update(query, args);
    }


    // Delete User by ID
    @Override
    public void deleteById(long id) {

        String query = "delete from "+TableName+" where id=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        int out = jdbcTemplate.update(query, id);

    }


    //Get All Users List
    @Override
    public List<User> getAll(long i) {
        String query = "SELECT * FROM "+TableName+" LIMIT "+String.valueOf(itemsOnPage) +" OFFSET "+String.valueOf((i-1)*itemsOnPage);
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


    //  Get Records count
    @Override
    public long getCount() {
        String query = "select count(*) from " + TableName;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForObject(query, Long.class);
    }


    //  Get missing records
    @Override
    public String getMissings() {

        // if table is empty return "There are no missing Records";
        if(getCount() == 0){
            return "There are no missing Records";
        }

        String query = "select start, stop from (\n" +
                "  select m.id + 1 as start,\n" +
                "    (select min(id) - 1 from "+TableName+" as x where x.id > m.id) as stop\n" +
                "  from "+TableName+" as m\n" +
                "    left outer join "+TableName+" as r on m.id = r.id - 1\n" +
                "  where r.id is null\n" +
                ") as x\n" +
                "where stop is not null;";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Long> start = new ArrayList<Long>();
        List<Long> stop = new ArrayList<Long>();

        List<Map<String, Object>> userRows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> userRow : userRows) {
            start.add(Long.parseLong(String.valueOf(userRow.get("start"))));
            stop.add(Long.parseLong(String.valueOf(userRow.get("stop"))));
        }

        // The query above finds missing records IDs intervals between existing real number sequence
        // and will not find the first/last N missing records.

        // Checking and finding first N missing records
        StringBuilder stb = new StringBuilder();
        long n = 1;
        while (isExists(n) == 0){
            stb.append(n);
            stb.append(',');
            ++n;
        }
        // if no missing in sequence
        if(start.size() == 0 ){
            if(isExists(1) == 1){
                return "There are no missing Records";
            }
            return stb.toString();
        }

        // if there are missing records in sequence
        for(int i = 0; i<start.size(); i++){
            for(long j = start.get(i); j <= stop.get(i); j++  ){
                stb.append(j);
                stb.append(',');
            }
        }
        return stb.toString();
    }

    // checking ID exists or not)
    public long isExists(long id ){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Long ID = jdbcTemplate.queryForObject("SELECT count(*) FROM " + TableName + " WHERE ID = ?", new Object[]{id}, Long.class);
        return ID;
    }

}
