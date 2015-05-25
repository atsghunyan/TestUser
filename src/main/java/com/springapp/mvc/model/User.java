package com.springapp.mvc.model;

/**
 * Created by Arthur's Notebook on 5/14/2015.
 */

import java.util.Date;


public class User {

    private int id;
    private String name;
    private Date createdDate;
    private Date modifiedDate;

    // Setters, Getters
    // Set/Get ID
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    // Set/Get Name
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    // Set/Get Created Date
    public void setCreatedDate(Date createdDate){
        this.createdDate = createdDate;
    }
    public Date getCreatedDate(){
        return createdDate;
    }

    // Set/Get Modified Date
    public void setModifiedDate(Date modifiedDate){
        this.modifiedDate = modifiedDate;
    }
    public Date getModifiedDate(){
        return modifiedDate;
    }

    // Override toString()
    @Override
    public String toString(){
        return "{ID="+id+",Name="+name+",CreatedDate="+createdDate+",ModifiedDate="+modifiedDate+"}";
    }
}
