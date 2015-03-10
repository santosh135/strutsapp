/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invent.Actions;

import com.invent.Dao.Dao;
import com.invent.model.Product;
import com.invent.model.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author santosh1.yadav
 */
public class HistoryAction extends ActionSupport{
    private Dao dao;
    private Product product;
    private Integer ProductId;
    
    public Dao getDao() {
        return dao;
    }
    public void setDao(Dao dao) {
        this.dao = dao;
    }
        
   
public Integer getProductId() {
        return ProductId;
    }
   
    public String getHistory() throws Exception {
        String result="failed";
        dao=new Dao();
        setProduct(new Product());
        getProduct().setProductId(getProductId());
        System.out.println(getProductId());
         result="success";
        
        /*
        ValueStack stack=ActionContext.getContext().getValueStack();
        System.out.println(stack);
        System.out.println(stack.size());
        */
        return result;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @param ProductId the ProductId to set
     */
    public void setProductId(Integer ProductId) {
        this.ProductId = ProductId;
    }
    
    @Override
    public void validate() {
        if(getProductId()==null){
            addFieldError("ProductId"," \t Product Id Required");
        }
    }
    
}





