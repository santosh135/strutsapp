/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invent.Dao;

/**
 *
 * @author santosh1.yadav
 */


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.invent.model.Product;
import com.invent.model.User;
import com.invent.model.Request;
public class Dao {
    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;
    public Dao() {
        try {
             
            Class.forName("com.mysql.jdbc.Driver");
            
            con=DriverManager.getConnection("jdbc:mysql://localhost/invent", "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean addRequest(Request product){
        boolean added=false;
        try {
            System.out.println((product.getProductid()));
            st=con.prepareStatement("insert into OrderStatus (ProductId,StartDate,EndDate,ReqPrice) values(?,?,?,?)");
            st.clearParameters();
           
            st.setInt(1,(product.getProductid()));
            st.setString(2,product.getStartDate());
            st.setString(3,product.getEndDate());
            st.setInt(4,Integer.parseInt(product.getProductprice()));
            
            int count=st.executeUpdate();
            if(count==1){
                added=true;
                System.out.println("+++++++++++++ Record Added+++++++");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return added;
    }
    public void close(){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isValid(User user){
        boolean valid=false;
        try {
            st=con.prepareStatement("select * from User where username " +
                    "like ? and password like ?");
            st.clearParameters();
            st.setString(1,user.getUserName());
            st.setString(2,user.getPassword());
            rs=st.executeQuery();
            if(rs.next()){
                valid=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }
    public ArrayList<Request>getRequest(){
        ArrayList<Request>categoryList=new ArrayList<Request>();
        try {
            st=con.prepareStatement("SELECT  RequestId,ProductId ,StartDate, EndDate, ReqPrice ,Status FROM OrderStatus where Status='Pending'");
            rs=st.executeQuery();
            while(rs.next()){
                
                categoryList.add(new Request(rs.getInt("RequestId"),rs.getInt("ProductId"),rs.getString("StartDate"),rs.getString("EndDate"),rs.getInt("ReqPrice"),rs.getString("Status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Request c : categoryList){
            System.out.println(c.getRequestId());
        }
        return categoryList;
    }
    
    
    
    public boolean UpdateStatus(String a,String b){
        boolean added=false;
        try {
            System.out.println(Integer.parseInt(a));
            st=con.prepareStatement("update OrderStatus set Status=? where RequestId=?");
            st.clearParameters();
           
            st.setString(1,b);
            st.setInt(2,Integer.parseInt(a));
            
                      
            int count=st.executeUpdate();
            if(count==1){
                added=true;
                System.out.println("+++++++++++++ Record Added+++++++");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return added;
    }
    
    
    public ArrayList<Product>getCatalogue(){
        ArrayList<Product>categoryList=new ArrayList<Product>();
        try {
            st=con.prepareStatement("select Id,Name,Price from Product");
            rs=st.executeQuery();
            while(rs.next()){
                
                categoryList.add(new Product(rs.getInt("Id"),rs.getString("Name"),rs.getInt("Price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Product c : categoryList){
            System.out.println(c.getProductname());
        }
        return categoryList;
    }
    
    public ArrayList<Request> getRequestStatus(Integer a){
        ArrayList<Request> categoryList=new ArrayList<Request>();
        try {
            st=con.prepareStatement("SELECT  ProductId ,StartDate, EndDate, ReqPrice ,Status FROM OrderStatus where ProductId=?");
            st.clearParameters();
            
            st.setInt(1,a);
            rs=st.executeQuery();
            while(rs.next()){
                
                categoryList.add(new Request(a,rs.getInt("ProductId"),rs.getString("StartDate"),rs.getString("EndDate"),rs.getInt("ReqPrice"),rs.getString("Status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Request c : categoryList){
            System.out.println(c.getRequestId());
        }
        return categoryList;
    }
    
    
}