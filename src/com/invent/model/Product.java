/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invent.model;

/**
 *
 * @author santosh1.yadav
 */


import java.io.Serializable;
import java.util.ArrayList;

/** @author Hibernate CodeGenerator */
public class Product implements Serializable {

	ArrayList<Product> list;
	
    /** identifier field */
    private Integer productId;

    /** persistent field */
    private String productname;

    /** persistent field */
    private Integer productprice;

    
    
    
    
    

    /** full constructor */
    public Product(Integer productid, String productname, Integer productprice) {
        this.productId = productid;
       
        this.productname = productname;
        this.productprice = productprice;
       
        
    }

    /** default constructor */
    public Product() {
    }

    /** minimal constructor */
    

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productid) {
        this.productId = productid;
    }

    

    public String getProductname() {
        return this.productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Integer getProductprice() {
        return this.productprice;
    }

    public void setProductprice(Integer productprice) {
        this.productprice = productprice;
    }

    

}

