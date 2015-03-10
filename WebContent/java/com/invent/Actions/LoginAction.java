/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invent.Actions;

/**
 *
 * @author santosh1.yadav
 */
import java.util.ArrayList;
import java.util.Map;

import com.invent.Dao.Dao;
import com.invent.model.Product;
import com.invent.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private String userName;
    private String password;
    private User user;
    private Dao dao;
    
   
    public Dao getDao() {
        return dao;
    }
    public void setDao(Dao dao) {
        this.dao = dao;
    }
        public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String execute() throws Exception {
        String result="failed";
        
        System.out.println(userName+" : "+password);
        dao=new Dao();
        user=new User();
        user.setUserName(getUserName());
        user.setPassword(getPassword());
        setUser(user);
        if(dao.isValid(user)){
            if(!(user.getUserName().equals("admin")))
            result="success";
            if(user.getUserName().equals("admin"))
                result="successs";
        }else{
            addActionError("Invalid Username or Password");
            result="error";
        }
        dao.close();
        /*
        ValueStack stack=ActionContext.getContext().getValueStack();
        System.out.println(stack);
        System.out.println(stack.size());
        */
        return result;
    }
    @Override
    public void validate() {
        if(getUserName().length()==0){
            addFieldError("userName"," \t User Name is Required");
        }
        if(getPassword().length()==0){
            addFieldError("password", "PASSWORD is Required");
        }else if(getPassword().length()<5){
            addFieldError("password","PASSWORD must be MINIMUM 5 characters");
        }
    }
}

