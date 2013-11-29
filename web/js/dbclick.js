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

function dbclickBorrowMaterial(name)
{    
    var tmp = document.createElement("form");
    var action = "BorrowMaterial?name=" + name;
    tmp.action = action;
 //   alert("action: " + action);
    tmp.method = "post";
    document.body.appendChild(tmp);
    tmp.submit();  
}

function dbclickReturnMaterial(name)
{    
    var tmp = document.createElement("form");
    var action = "ReturnMaterial?name=" + name;
    tmp.action = action;
//    alert("action: " + action);
    tmp.method = "post";
    document.body.appendChild(tmp);
    tmp.submit();  
}

var timer;
function dbclickReduceMaterial(id)
{    
    clearTimeout(timer);
    var tmp = document.createElement("form");
    var action = "MaterialAmount?id=" + id
                 + "&type=reduce";
    tmp.action = action;
    
    tmp.method = "post";
    document.body.appendChild(tmp);
    tmp.submit();  
}

//set timeout as single click
function onClickIncreaseMaterial(id)
{   
    timer = setTimeout(function() { 
        var tmp = document.createElement("form");
        var action = "MaterialAmount?id=" + id
                     + "&type=increase";
        tmp.action = action;
        
        tmp.method = "post";
        document.body.appendChild(tmp);
        tmp.submit();    
    }, 300);         
}