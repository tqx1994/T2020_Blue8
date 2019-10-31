<%-- 
    Document   : Accounts
    Created on : 31 Oct, 2019, 11:30:40 AM
    Author     : hh_94
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import= "newpackage.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<HTML>
    <HEAD>
        <TITLE>DBS Accounts Page</TITLE>
    </HEAD>

    <BODY>
        <%
            String gender = (String) session.getAttribute("gender");
            String firstName = (String) session.getAttribute("firstName");
            String lastName = (String) session.getAttribute("lastName");
            String lastLogIn = (String) session.getAttribute("lastLogIn");
            lastLogIn = lastLogIn.replace('T', ' ');
            lastLogIn = lastLogIn.substring(0, lastLogIn.length() - 9);
            /*String accountId = (String) session.getAttribute("accountId");
            String currency = (String) session.getAttribute("currency");
            String displayName = (String) session.getAttribute("displayName");
            String availableBalance = (String) session.getAttribute("availableBalance");*/

        %>
        <H1>Hi <%if (gender.equals("Female")) {%>Miss <%} else {%>Mr <%}
            out.print(lastName + " " + firstName);%></H1>
        <H4>Your last login was <%out.print(lastLogIn); %></H4>
            <%
                //Object acct = session.getAttribute("depAccounts");
                //Map<String,Integer> depAccounts = null;
                //if (acct instanceof Map) {
                //    depAccounts = (Map) session.getAttribute("depAccounts");
                //}
            %>
        <TABLE border="1">
            <TR>
                <TH>Deposit Account(s)</TH>
                <TH>Balance</TH>
            </TR>
            <%
                /*Iterator iter = depAccounts.keySet().iterator();
                while (iter.hasNext()) {
                    String depAcctNum = (String) iter.next();
                    int bal = (int) depAccounts.get((String)iter.next());
                }*/%>
            <TR>
                <TD> <a href="Transaction.jsp?acct=11111<%//=accountId%>">11111<%//out.print(displayName +" " +accountId);%></a></td>
                <TD> <%//out.print(currency+" "+availableBalance);%></td>
            </TR>
            <%//}%>
        </TABLE>
    </BODY>
</HTML>