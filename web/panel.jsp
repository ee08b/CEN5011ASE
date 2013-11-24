<%-- 
    Document   : panel
    Created on : Nov 21, 2013, 8:58:10 PM
    Author     : zsx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library</title>
    </head>
    <body>
         <div id="register" class="animate form">
            <form  action="/Library/AddUser" method="post"> 
                <h1> Sign up </h1> 
                <p> 
                    <label for="usernamesignup" class="uname" data-icon="u">Username</label>
                    <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="mysuperusername690" />
                </p>
                <p> 
                    <label for="passwordsignup" class="youpasswd" data-icon="p">Password </label>
                    <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="eg. X8df!90EO"/>
                </p>
                <p> 
                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Confirm password </label>
                    <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="eg. X8df!90EO"/>
                </p>
                <p>
                <select id="rolesignup" name="rolesignup">
                    <option selected="selected" value="patron">patron</option>
                    <option value="librarian">librarian</option>
                    <option value="admin">admin</option>
                </select>
                </p>
                <p class="signin button"> 
                    <input type="submit" value="Add"/> 
				</p>
            </form>
        </div>
        
        <%String showAllLog = (String)session.getAttribute("showAllLog"); %> 
		<%=showAllLog %>
        
        <%String showAllUser = (String)session.getAttribute("showAllUser"); %> 
		<%=showAllUser %>
        
    </body>
</html>
