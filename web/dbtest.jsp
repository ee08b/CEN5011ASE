<%-- 
    Document   : dbtest
    Created on : Nov 19, 2013, 11:17:44 AM
    Author     : zsx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <html:form action=""><br>
		<table width="550" border="0" align=left>
		<tr>
		<td colspan=2 align="center"><p id="message"><%=message %><%session.setAttribute("message","");%></p></td>
		</tr>
          <tr>
            <td width="120"><label>&nbsp;&nbsp;Account</label></td>            
            <td width="140"><html:text property="account" size="10"/><br/><html:errors property="account"/></td>
          </tr>
          <tr>
            <td width="120"><label>&nbsp;&nbsp;Password</label></td>           
            <td width="140"><html:password property="password" size="10"/><br/><html:errors property="password"/></td>
          </tr>
          <tr>
            <td width="120"><label>&nbsp;&nbsp;Identifying code</label></td>           
            <td  ><html:text property="identify" size="5"/><html:image src="image.jsp"/><br/><html:errors property="identify"/></td><td></td>
          </tr>
          <tr>
            <td  colspan=2 align="center">
            		<br>
            	  <html:submit/>
            	  &nbsp;&nbsp;
            	  <html:reset/>
            	  <br><br>
       	    <a href="registeruser.jsp" target="_self">Register new user</a></p></td>
          </tr>
        </table>
        </html:form>
    </body>
</html>
