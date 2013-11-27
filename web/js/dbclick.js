function dbclickDeleteUser(id)
{
    //$(this).slideup();
    //alert(id);
    //document.getElementById("demo").innerHTML="Hello World";
    
    var tmp = document.createElement("form");
    var action = "DeleteUser?id=" + id;
    tmp.action = action;
    //alert("action: " + action);
    tmp.method = "post";
    document.body.appendChild(tmp);
    tmp.submit();  
}

function dbclickDeleteRoomResv(id)
{
    //$(this).slideup();
    //alert(id);
    //document.getElementById("demo").innerHTML="Hello World";
    
    var tmp = document.createElement("form");
    var action = "DeleteUser?id=" + id;
    tmp.action = action;
    //alert("action: " + action);
    tmp.method = "post";
    document.body.appendChild(tmp);
    tmp.submit();  
}