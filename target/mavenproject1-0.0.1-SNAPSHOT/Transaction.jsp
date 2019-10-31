<%-- 
    Document   : Transaction
    Created on : 31 Oct, 2019, 3:03:10 PM
    Author     : hh_94
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transaction Page</title>
    </head>
    <body>
        <%String acct = request.getParameter("acct");%>
        <h2>Transaction History for account: <%out.print(acct);%></h2>

    </body>
</html>
