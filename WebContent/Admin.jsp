<%-- 
    Document   : normal.jsp
    Created on : 9 Oct, 2014, 10:19:01 AM
    Author     : santosh1.yadav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <title>Admin page</title>
    </head>
    <div id="container">
    <body>
        <div id="header">
        <h1>Inventory Management</h1>
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
        <div id="section-navigation">
				<ul>
                                    <li><a href="Approve.jsp">Approve Request</a></li>
					<a href="History.jsp">See Product History</a>
					
				</ul>
			</div>
    </body>
    </div>
</html>
