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
	
	<script language="javascript" src="js/toggleCollapseExpand.js" ></script>
    <script language="javascript" src="js/dbclick.js" ></script>
	<script language="javascript" src="js/jquery-1.2.4a.js"></script>
	<script language="javascript" src="js/ui.base.min.js"></script>
	<script language="javascript" src="js/ui.droppable.min.js"></script>
	<script language="javascript" src="js/ui.draggable.min.js"></script>
	<script language="javascript" src="js/ui.sortable.min.js"></script>
	<script language="javascript" src="js/17.js"></script>
	<script language="javascript" src="js/dropdown-list.js"></script>
    
    <style>
        tr:hover {background-color: yellow;}
        </style>
</head><body onload="ExpandCollapse();">
<div id="sort1" class="groupWrapper">
	<div id="Room" class="groupItem">
		<div style="-moz-user-select: none;" class="itemHeader">Room reservation<a href="#" class="closeEl">[-]</a></div>
		<div class="itemContent">	
           <form action="/Library/AddMaterial" method="post">
               <select id="room" name="room">
                   <option value="301">301</option>
                   <option value="302">302</option>
                   <option value="303">303</option>
                   <option value="302">304</option>
                   <option value="303">305</option>
               </select>
               <input id="datesignup" name="datesignup" required="required" type="text" placeholder="date" />
               <input id="time1signup" name="time1signup" required="required" type="text" placeholder="time from" />
               <input id="time2signup" name="typesignup" required="required" type="text" placeholder="time to" />
               &nbsp;&nbsp;&nbsp;
               <input type="submit" value="Reserve"/>                 
           </form>
           <%String showAllRoomReserv = (String) session.getAttribute("showAllRoomReserv");%> 
           <%=showAllRoomReserv %>
		</div>
	</div>
	
	<div id="news" class="groupItem">
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
    <div id="History" class="groupItem">
		<div style="-moz-user-select: none;" class="itemHeader">History records<a href="#" class="closeEl">[-]</a></div>
		<div class="itemContent">
            <%String showAllLog = (String) session.getAttribute("showAllLog");%> 
            <%=showAllLog%>
		</div>
	</div>
	<p>&nbsp;</p>
</div>
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
	<div id="Material" class="groupItem">
		<div style="-moz-user-select: none;" class="itemHeader">Material<a href="#" class="closeEl">[-]</a></div>
		<div class="itemContent">
            <form action="/Library/AddMaterial" method="post">
                <input id="materialsignup" name="materialsignup" required="required" type="text" placeholder="new material" />
                <input id="authorsignup" name="authorsignup" required="required" type="text" placeholder="author" />
                <input id="typesignup" name="typesignup" required="required" type="text" placeholder="type" />
                <input id="ISBNsignup" name="ISBNsignup" required="required" type="text" placeholder="ISBN" />
                <input id="numbersignup" name="amountsignup" required="required" type="text" placeholder="amount" />

                <input type="submit" value="Add Material"/>
            </form>
            <%String showAllMaterial = (String) session.getAttribute("showAllMaterial");%> 
            <%=showAllMaterial%>
		</div>
	</div>
	<p>&nbsp;</p>
</div>
</body></html>
