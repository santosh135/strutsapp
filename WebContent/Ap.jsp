<%-- 
    Document   : HistResult.jsp
    Created on : 9 Oct, 2014, 2:07:39 PM
    Author     : santosh1.yadav
--%>

<%@page import="java.util.Enumeration"%>
<%@ page import="com.invent.Dao.Dao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
 <link rel="stylesheet" href="style.css" type="text/css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product History</title>
</head>
<div id="container">
   
<body>
    <div id="header">
   <h1>Operation Successful</h1>
   </div>
    <div id="navigation">
		<ul>
			<li><a href="#">Home</a></li>
			<li><a href="#">About</a></li>
			<li><a href="#">Services</a></li>
			<li><a href="#">Contact us</a></li>
                       <li><a href="login.jsp">Log out</a></li>
		</ul>
	</div>
    
    
    <%
  
   String a=request.getParameter("requestId");
   String b=request.getParameter("Action");

%>
   
  
    <% Dao dao= new Dao();
       dao.UpdateStatus(a, b);
    
    %>

    
    
     
     <div id="content">
      <TD><input type="button" name="Go Back" value="Go Back" onClick="javascript:window.location='Approve.jsp';" style="background-color:#49743D;font-weight:bold;color:#ffffff;">    
   
</body>

    </div>
</div>
</html>
