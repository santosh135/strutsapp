<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.invent.Dao.Dao" %>
<%@ page import="com.invent.model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
 <link rel="stylesheet" href="newcss.css" type="text/css"/>
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
<html lang="en">
    <div id="header">
<head>
   <title>Request</title>
   <script src="datetimepicker_css.js"></script>
</head>
    </div><div id="header">
        <h1>Create Request</h1>
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
    <div id="container">
<body>

    
      <% Dao dao=new Dao();
      ArrayList<Product> list= dao.getCatalogue();
      request.setAttribute("list", list);
    %>
     
   
   <div id="content-container"> 
       <div id="content">
           <table align="center" border="1" cellpadding="5" bgcolor="#ccc" class="hovertable">
            <caption>Product Catalogue</caption>
            <tr>
                <th>ProductName</th>
                <th>ProductId</th>
                <th>Price</th>
              </tr>
            
           <c:forEach var="user" items="${list}">
                <tr>
                    <td><c:out value="${user.productname}" /></td>
                    <td><c:out value="${user.productId}" /></td>
                    <td><c:out value="${user.productprice}" /></td>
                   
                </tr>
            </c:forEach>
        </table>
       </div>
  
        <div id="aside">
            <br></br>
           <form action=Request>
               <label for="productid">Product Id</label><br/> 
              <INPUT TYPE="TEXT" NAME="productid">
             
              <label for="RequestedPrice">Requested Price</label><br/>
            <INPUT TYPE="TEXT" NAME="productprice">
             
             
                   
                    <label for="StartDate">StartDate</label><br/>
                  <input type="Text" id="startDate" name="StartDate"maxlength="20" size="20"/>
     <img src="images2/cal.gif" onclick="javascript:NewCssCal('startDate')" style="cursor:pointer"/>
    
                 
      <label for="StartDate">EndDate</label><br/>
                   <input type="Text" id="EndDate" name="EndDate"maxlength="20" size="20"/>
     <img src="images2/cal.gif" onclick="javascript:NewCssCal('EndDate')" style="cursor:pointer"/>
    
     
      <input type="submit" value="Create" align="right">
           </form>
        </div>
   </div>
</body>
    </div>
</html>