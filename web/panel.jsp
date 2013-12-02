<%-- 
    Document   : panel
    Created on : Nov 21, 2013, 8:58:10 PM
    Author     : zsx
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Library</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link href="http://assets.tumblr.com/images/default_avatar_16.gif" rel="shortcut icon" />
	<link rel="alternate" type="application/rss+xml" href="">
	<link rel="stylesheet" type="text/css" href="css/sort.css" />
	<link rel="stylesheet" type="text/css" href="css/Postage.css" />
	<link rel="stylesheet" type="text/css" href="css/17.css" />
	<link rel="stylesheet" type="text/css" href="css/dropdown-list.css" />
	<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
    <link rel="stylesheet" href="/resources/demos/style.css">
    
	<script language="javascript" src="js/toggleCollapseExpand.js" ></script>
    <script language="javascript" src="js/dbclick.js" ></script>
	<script language="javascript" src="js/jquery-1.2.4a.js"></script>
	<script language="javascript" src="js/ui.base.min.js"></script>
	<script language="javascript" src="js/ui.droppable.min.js"></script>
	<script language="javascript" src="js/ui.draggable.min.js"></script>
	<script language="javascript" src="js/ui.sortable.min.js"></script>
	<script language="javascript" src="js/17.js"></script>
	<script language="javascript" src="js/dropdown-list.js"></script>
    <script language="javascript" src="js/jquery-1.9.1.js"></script>
    <script language="javascript" src="js/jquery-ui.js"></script>
    
    <script>
    $(function() {
    $( "#datesignup" ).datepicker(
            {dateFormat: 'yy-mm-dd'});
    });
    </script>

</head><body onload="ExpandCollapse();">
<%String role = (String) session.getAttribute("role");%>
<div id="sort1" class="groupWrapper">
	<div id="Room" class="groupItem">
		<div style="-moz-user-select: none;" class="itemHeader">Room reservation<a href="#" class="closeEl">[-]</a></div>
		<div class="itemContent">	
           <form action="/Library/AddRoomRsv" method="post">
               <select id="roomsignup" name="roomsignup">
                   <option selected disabled>Room</option>
                   <option value="301">301</option>
                   <option value="302">302</option>
                   <option value="303">303</option>
                   <option value="302">304</option>
                   <option value="303">305</option>
               </select>
               <input id="datesignup" name="datesignup" required="required" type="text" placeholder="date" />
               <select id="time1signup" name="time1signup" >
                   <option selected disabled>from</option>
                   <option value="8:00:00">8 am</option>
                   <option value="9:00:00">9 am</option>
                   <option value="10:00:00">10 am</option>
                   <option value="11:00:00">11 am</option>
                   <option value="12:00:00">12 pm</option>
                   <option value="13:00:00">1 pm</option>
                   <option value="14:00:00">2 pm</option>
                   <option value="15:00:00">3 pm</option>
                   <option value="16:00:00">4 pm</option>
                   <option value="17:00:00">5 pm</option>
                   <option value="18:00:00">6 pm</option>
               </select>
               <select id="time2signup" name="time2signup" >
                   <option selected disabled>to</option>
                   <option value="8:00:00">8 am</option>
                   <option value="9:00:00">9 am</option>
                   <option value="10:00:00">10 am</option>
                   <option value="11:00:00">11 am</option>
                   <option value="12:00:00">12 pm</option>
                   <option value="13:00:00">1 pm</option>
                   <option value="14:00:00">2 pm</option>
                   <option value="15:00:00">3 pm</option>
                   <option value="16:00:00">4 pm</option>
                   <option value="17:00:00">5 pm</option>
                   <option value="18:00:00">6 pm</option>
               </select>
               &nbsp;&nbsp;&nbsp;
               <input type="submit" value="Reserve"/>                 
           </form>
           <%String showAllRoomReserv = (String) session.getAttribute("showAllRoomReserv");%> 
           <%=showAllRoomReserv %>
		</div>
	</div>
	
	<div id="user" class="groupItem" <%String userHideSet = ""; %> 
         <% if(!role.equals("admin")) { userHideSet = "hidden"; } %>    
        <%=userHideSet %>
        >
		<div style="-moz-user-select: none;" class="itemHeader">User<a href="#" class="closeEl">[-]</a></div>
		<div class="itemContent">          
            <form action="/Library/AddUser" method="post">
                <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="new username" />
                <input id="passwordsignup" name="passwordsignup" required="required" type="text" placeholder="new password"/>

                <select id="rolesignup" name="rolesignup">
                    <option selected="selected" value="patron">patron</option>
                    <option value="librarian">librarian</option>
                    <option value="admin">admin</option>
                </select>&nbsp;&nbsp;&nbsp;
                <input type="submit" value="Add user"/>                 
            </form>
            <%String showAllUser = (String) session.getAttribute("showAllUser");%> 
            <%=showAllUser%>
		</div>
	</div>
    <div id="History" class="groupItem" <%String historyHideSet = ""; %> 
        <% if(!role.equals("admin") && !role.equals("librarian")) { historyHideSet = "hidden"; } %>    
        <%=historyHideSet %>         
         >
		<div style="-moz-user-select: none;" class="itemHeader">History<a href="#" class="closeEl">[-]</a></div>
		<div class="itemContent">
            <%String showAllLog = (String) session.getAttribute("showAllLog");%> 
            <%=showAllLog%>
		</div>
	</div>
	<p>&nbsp;</p>
</div>
        <p align="center">Hello <%String username = (String) session.getAttribute("username");%> 
        <%=username%>!&nbsp;&nbsp;&nbsp;&nbsp;Role: <%=role %>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/Library/Logout">Log out</a></p>
<div id="sort2" class="groupWrapper">    
	<div id="Material_Rserv" class="groupItem">
		<div style="-moz-user-select: none;" class="itemHeader">Material reservation<a href="#" class="closeEl">[-]</a></div>
		<div class="itemContent">
            <form action="/Library/SearchMaterial" method="post">
                <input id="materialSearch" name="materialSearch" type="text" placeholder="material name" />
                <input id="authorSearch" name="authorSearch" type="text" placeholder="author" />
                <input id="typeSearch" name="typeSearch" type="text" placeholder="type" />
                <input id="ISBNSearch" name="ISBNSearch" type="text" placeholder="ISBN" />
                <input id="numberSearch" name="numberSearch" type="text" placeholder="number" />

                <input type="submit" value="Search"/>
            </form>
            <%String searchMaterial = (String) session.getAttribute("searchMaterial");%> 
           <!--  <%if(searchMaterial==null) {searchMaterial="No result found.";} %> -->
            <%=searchMaterial %>
            <br><br>
            <div><b>Borrowed Materials</b></div>
            <%String showAllMaterialOut = (String) session.getAttribute("showAllMaterialOut");%> 
            <%if(showAllMaterialOut==null) {showAllMaterialOut="No materials borrowed yet. ";} %>
            <%=showAllMaterialOut %>
		</div>
	</div>
	<div id="Material" class="groupItem" <%String materialHideSet = ""; %> 
        <% if(!role.equals("admin") && !role.equals("librarian")) { materialHideSet = "hidden"; } %>    
        <%=materialHideSet %>
        >
		<div style="-moz-user-select: none;" class="itemHeader">Material<a href="#" class="closeEl">[-]</a></div>
		<div class="itemContent">
            <form action="/Library/NewMaterial" method="post">
                <input id="materialsignup" name="materialsignup" required="required" type="text" placeholder="new material" />
                <input id="authorsignup" name="authorsignup" required="required" type="text" placeholder="author" />
                <input id="typesignup" name="typesignup" required="required" type="text" placeholder="type" />
                <input id="ISBNsignup" name="ISBNsignup" required="required" type="text" placeholder="ISBN" />
                <input id="numbersignup" name="numbersignup" required="required" type="text" placeholder="amount" />

                <input type="submit" value="Add Material"/>&nbsp;&nbsp;&nbsp;
                <span style="font-style: color:grey">Click to add 1, double-click to reduce 1</span>
            </form>
            <%String showAllMaterial = (String) session.getAttribute("showAllMaterial");%> 
            <%=showAllMaterial%>
		</div>
	</div>
	<p>&nbsp;</p>
</div>
</body></html>
