/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.invent.model;

/**
 *
 * @author santosh1.yadav
 */
public class Request {
    private Integer requestId;
     
    private Integer productid;

    /** persistent field */
    private String productname;

    /** persistent field */
    private String productprice;
    
    private String startDate;
    
    private String endDate;
    private String status;
    
    private Integer requestedPrice;
    
  public Request(){
      
  }
   public Request(Integer requestId,Integer productid,String StartDate,String EndDate,Integer requestedPrice,String Status){
       this.startDate=StartDate;
       this.endDate=EndDate;
       this.status=Status;
       this.productid=productid;
       this.requestId=requestId;
       this.requestedPrice=requestedPrice;
   }
public Integer getRequestId() {
	return requestId;
}
public void setRequestId(Integer requestId) {
	this.requestId = requestId;
}
public Integer getProductid() {
	return productid;
}
public void setProductid(Integer productid) {
	this.productid = productid;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getProductprice() {
	return productprice;
}
public void setProductprice(String productprice) {
	this.productprice = productprice;
}
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Integer getRequestedPrice() {
	return requestedPrice;
}
public void setRequestedPrice(Integer requestedPrice) {
	this.requestedPrice = requestedPrice;
}  
  
    
}
