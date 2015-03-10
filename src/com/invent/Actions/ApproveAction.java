/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invent.Actions;

import com.invent.Dao.Dao;
import com.invent.model.Product;
import com.invent.model.User;

/**
 *
 * @author santosh1.yadav
 */
public class ApproveAction {
    Integer RequestId;
    public Integer getRequestId() {
        return RequestId;
    }
    public void setRequestId(User user) {
        this.RequestId = RequestId;
}


public String adminAction() throws Exception {
        String result="failed";
       
        
        result="success";
        
        /*
        ValueStack stack=ActionContext.getContext().getValueStack();
        System.out.println(stack);
        System.out.println(stack.size());
        */
        return result;
    }








}

