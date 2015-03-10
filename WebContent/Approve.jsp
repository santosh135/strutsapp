<%-- 
    Document   : HistResult.jsp
    Created on : 9 Oct, 2014, 2:07:39 PM
    Author     : santosh1.yadav
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.invent.Dao.Dao" %>
<%@ page import="com.invent.model.Request" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
 <link rel="stylesheet" href="style.css" type="text/css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<style type="text/css">
table.hovertable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
table.hovertable th {
	background-color:#c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.hovertable tr {
	background-color:#d4e3e5;
}
table.hovertable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.hovertable tr:hover {
          background-color: #ffff99;
        }
</style>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pending Requests</title>
</head>
<div id="container">
   
<body>
    <div id="header">
   <h1>Pending Order Requests</h1>
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
    
     
     
   
     
     <% Dao dao=new Dao();
     ArrayList<Request> list=dao.getRequest();
     request.setAttribute("list", list);
     %>
     
     
     <div id="content">
         <table align="center" border="1" cellpadding="5" bgcolor="#ccc" class="hovertable">
            <caption><br><b>Requests<b></br></caption>
            <tr> 
                <th>RequestId</th>
                <th>ProductId</th>
                <th>StartDate</th>
                <th>EndDate</th>
                
                <th>Requested Price</th>
                <th>Status</th>
                <th>Approve</th>
                <th>Reject</th>
            </tr>
            
            <c:forEach var="user" items="${list}">
                <tr>
                    <td><c:out value="${user.requestId}" /></td>
                    <td><c:out value="${user.productid}" /></td>
                    <td><c:out value="${user.startDate}" /></td>
                    <td><c:out value="${user.endDate}" /></td>
                   
                    <td><c:out value="${user.requestedPrice}"/></td>
                     <td><c:out value="${user.status}" /></td>
                    <input type="hidden"  name="requestId" value=${user.requestId}>
                    <TD><input type="button" name="approve" value="Approve" onClick="javascript:window.location='Ap.jsp?requestId='+${user.requestId}+ '&Action=Approved';" style="background-color:#49743D;font-weight:bold;color:#ffffff;">  
  
                </TD>  
                <TD><input type="button" name="reject" value="Reject" onClick="javascript:window.location='Ap.jsp?requestId='+${user.requestId}+ '&Action=Rejected';"style="background-color:#ff0000;font-weight:bold;color:#ffffff;"></TD>  
                </tr>
            </c:forEach>
        </table>
   
</body>

    </div>
</div>
</html>
