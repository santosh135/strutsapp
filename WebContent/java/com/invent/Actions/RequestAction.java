/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invent.Actions;

import com.invent.Dao.Dao;
import com.invent.model.Request;
import com.invent.model.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author santosh1.yadav
 */
public class RequestAction extends ActionSupport{
      private Integer productid;

    
    private String productprice;
    
    private String StartDate;
    
    private String EndDate;
    private Request request;
    private Dao dao;
     
    
     @Override
    public String execute() throws Exception {
        String result="failed";
      System.out.println(getProductid() + getProductprice()+ getStartDate());  
       
        dao=new Dao();
       request=new Request();
        request.setProductid(getProductid());
        request.setStartDate(getStartDate());
        request.setEndDate(getEndDate());
        request.setProductprice(getProductprice());
        
       
       
        if(dao.addRequest(request)){
            System.out.println("id" + getProductid());
            result="success";
          
        }else{
            
            return "error";
        }
        dao.close();
        /*
        ValueStack stack=ActionContext.getContext().getValueStack();
        System.out.println(stack);
        System.out.println(stack.size());
        * 
        */ 
       
         result="success";
        return result;
    }

    
     public Integer getProductid() {
		return productid;
	}


	public void setProductid(Integer productid) {
		this.productid = productid;
	}


	public String getProductprice() {
		return productprice;
	}


	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}


	public String getStartDate() {
		return StartDate;
	}


	public void setStartDate(String startDate) {
		StartDate = startDate;
	}


	public String getEndDate() {
		return EndDate;
	}


	public void setEndDate(String endDate) {
		EndDate = endDate;
	}


	public Request getRequest() {
		return request;
	}


	public void setRequest(Request request) {
		this.request = request;
	}


	public Dao getDao() {
		return dao;
	}


	public void setDao(Dao dao) {
		this.dao = dao;
	}


	@Override
    public void validate() {
        if(getProductid()==null){
            addFieldError("productid","productid is Required");
        }
        if(getStartDate().length()==0){
            addFieldError("StartDate", "StartDate is Required");
        }else if(getEndDate().length()==0){
            addFieldError("EndDate","EndDate is Required");
        }
    }
    
    
}
