<%-- 
    Document   : newjsp
    Created on : Oct 10, 2014, 9:32:54 PM
    Author     : Incredible
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.invent.Dao.Dao"%>
 <link rel="stylesheet" href="newcss.css" type="text/css"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.invent.model.Request"%>
<!-- CSS goes in the document HEAD or added to your external stylesheet -->
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

<!DOCTYPE html>
<html>
    <head>
         <script src="1.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <div id="header">
        <h1>Search Product History</h1>
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
    <body>
       <body>
            <div id="container">
 <div id="wrapper">
  <h1>Sortable Table of Search Queries</h1>
  
  <table id="keywords" cellspacing="0" cellpadding="0" class="hovertable">
    <thead>
      <tr>
        <th><span>Keywords</span></th>
        <th><span>Impressions</span></th>
        <th><span>Clicks</span></th>
        <th><span>CTR</span></th>
        <th><span>Rank</span></th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td class="lalign">silly tshirts</td>
        <td>6,000</td>
        <td>110</td>
        <td>1.8%</td>
        <td>22.2</td>
      </tr>
      <tr>
        <td class="lalign">desktop workspace photos</td>
        <td>2,200</td>
        <td>500</td>
        <td>22%</td>
        <td>8.9</td>
      </tr>
      <tr>
        <td class="lalign">arrested development quotes</td>
        <td>13,500</td>
        <td>900</td>
        <td>6.7%</td>
        <td>12.0</td>
      </tr>
      <tr>
        <td class="lalign">popular web series</td>
        <td>8,700</td>
        <td>350</td>
        <td>4%</td>
        <td>7.0</td>
      </tr>
      <tr>
        <td class="lalign">2013 webapps</td>
        <td>9,900</td>
        <td>460</td>
        <td>4.6%</td>
        <td>11.5</td>
      </tr>
      <tr>
        <td class="lalign">ring bananaphone</td>
        <td>10,500</td>
        <td>748</td>
        <td>7.1%</td>
        <td>17.3</td>
      </tr>
    </tbody>
  </table>
  <div id="aside">
             <br>
           <form action=History>
               <label for="ProductId">Enter Product Id</label><br/> 
              <INPUT TYPE="TEXT" NAME="ProductId">
             
              
            
           
      <input type="submit" value="Search" align="right">
           </form>
        </div>
 </div> 
</body>
    </body>
 </div>
</html>
