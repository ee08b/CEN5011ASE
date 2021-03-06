/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import java.sql.ResultSet;
import struts.entity.DBMgr;
import java.util.*;
import java.text.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zsx
 */
public class ShowAll {
    public void refreshPanel() {
        this.showAllLog();
        this.showAllUser();
        this.showAllRoomReserv();
//        this.showAllMaterialOut();
        this.showAllMaterial();
    }
    public String showAllLog(){
        DBMgr dbmr = new DBMgr();    	
    	ResultSet rsLogon = dbmr.display("log");
        try {
            String tmp = "<table border=0 width=100%><tr>"
                    + "<th>user</th>"
                    + "<th>name</th>"
                    + "<th>type</th>"
                    + "<th>action</th>"
                    + "<th>date</th>"
                    + "<th>time</th>"
//                    + "<td>user</td>"
//                    + "<td>name</td>"
//                    + "<td>type</td>"
//                    + "<td>action</td>"
//                    + "<td>date</td>"
//                    + "<td>time</td>"
                    + "</tr>";
            while (rsLogon.next()){
                tmp += "<tr>";
                tmp += "<td>"+rsLogon.getString("user")+"</td>"+
                       "<td>"+rsLogon.getString("name")+"</td>"+
                       "<td>"+rsLogon.getString("type")+"</td>"+
                       "<td>"+rsLogon.getString("action")+"</td>"+
                       "<td>"+rsLogon.getDate("date")+"</td>"+
                       "<td>"+rsLogon.getTime("time")+"</td>";
                //"<td>"++"</td>"+
                tmp += "</tr>";
            }
            tmp += "</table>";
            //System.out.println("log: "+tmp);
            return tmp;
        }		
		catch(Exception e){
			System.out.print("\n fail \n");
			e.printStackTrace();
            System.out.println(e.getMessage()); 
            return null;
		}
		finally { 
		}	
    }
    
    public String showAllUser (){
        DBMgr dbmr = new DBMgr();    	
    	ResultSet rsLogon = dbmr.display("account");
        try {
            String tmp = "<table border=0 width=100%><tr>"
                    + "<th>username</th>"
                    + "<th>password</th>"
                    + "<th>role</th>"
//                    + "<td>username</td>"
//                    + "<td>password</td>"
//                    + "<td>role</td>"
                    + "</tr>";
            while (rsLogon.next()){
                tmp += "<tr ondblclick=\"dbclickDeleteUser(\'"
                        + rsLogon.getString("id")+"\')\">"+
                       "<td>"+rsLogon.getString("name")+"</td>"+
                       "<td>"+rsLogon.getString("password")+"</td>"+
                       "<td>"+rsLogon.getString("role")+"</td>"+
                       "</tr>";
            }
            tmp += "</table>";
            return tmp;
        }		
		catch(Exception e){
			System.out.print("\n fail \n");
			e.printStackTrace();
            System.out.println(e.getMessage()); 
            return null;
		}
		finally { 
		}
    }
    
    public String showAllRoomReserv (){
        DBMgr dbmr = new DBMgr();    	
    	ResultSet rsLogon = dbmr.display("room_rsv");
        try {
            String tmp = "<table border=0 width=100%><tr>"
                    + "<th>room</th>"
                    + "<th>user</th>"
                    + "<th>date</th>"
                    + "<th>from</th>"
                    + "<th>to</th>"
//                    + "<td>room</td>"
//                    + "<td>user</td>"
//                    + "<td>date</td>"
//                    + "<td>from</td>"
//                    + "<td>to</td>"
                    + "</tr>";
            while (rsLogon.next()){
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                
//                if(!dateFormat.format(new Date()).before(dateFormat.parse(rsLogon.getDate("date"))) &&
//                        rsLogon.getTime("time2") >= timeFormat.format(new Date())
                tmp += "<tr>"+
                       "<td>"+rsLogon.getString("room")+"</td>"+
                       "<td>"+rsLogon.getString("user")+"</td>"+
                       "<td>"+rsLogon.getDate("date")+"</td>"+
                       "<td>"+rsLogon.getTime("time1")+"</td>"+
                       "<td>"+rsLogon.getTime("time2")+"</td>"+
                       "</tr>";
            }
            tmp += "</table>";
            return tmp;
        }		
		catch(Exception e){
			System.out.print("\n fail \n");
			e.printStackTrace();
            System.out.println(e.getMessage()); 
            return null;
		}
		finally { 
		}
    }
        
    public String showAllMaterialOut (String username){
        DBMgr dbmr = new DBMgr();    	
    	ResultSet rsLogon = dbmr.display("material_rsv");
        
        try {
            String tmp = "<table border=0 width=100%><tr>"
                        + "<th>name</th>"
                        + "<th>user</th>"
                        + "<th>date</th>"
                        + "<th>time</th>"
//                    + "<td>name</td>"
//                    + "<td>user</td>"
//                    + "<td>date</td>"
//                    + "<td>time</td>"
                    + "</tr>";
//            if(rsLogon.first()) {
                while (rsLogon.next()) {
                    if(rsLogon.getString("user").equals(username)) {
                        tmp += "<tr ondblclick=\"dbclickReturnMaterial(\'"
                                + rsLogon.getString("name")+"\')\">"
                                + "<td>" + rsLogon.getString("name") + "</td>"
                                + "<td>" + rsLogon.getString("user") + "</td>"
                                + "<td>" + rsLogon.getDate("date") + "</td>"
                                + "<td>" + rsLogon.getTime("time") + "</td>";
                        tmp += "</tr>";
                    }
                }
                tmp += "</table>";
//            } else {
//                tmp = "No materials borrowed yet. ";
//            }
            return tmp;
        }		
		catch(Exception e){
			System.out.print("\n fail \n");
			e.printStackTrace();
            System.out.println(e.getMessage()); 
            return null;
		}
		finally { 
		}
    }
    
    public String showAllMaterial(){
        DBMgr dbmr = new DBMgr();    	
    	ResultSet rsLogon = dbmr.display("material");
        try {
            String tmp = "<table border=0 width=100%><tr>"
                    + "<th>name</th>"
                    + "<th>author</th>"
                    + "<th>type</th>"
                    + "<th>ISBN</th>"
                    + "<th>available</th>"
                    + "<th>amount</th>"
//                    + "<td>name</td>"
//                    + "<td>author</td>"
//                    + "<td>type</td>"
//                    + "<td>ISBN</td>"
//                    + "<td>available</td>"
//                    + "<td>amount</td>"
                    + "</tr>";
            while (rsLogon.next()){
                String tmp0 = "<tr ondblclick=\"dbclickReduceMaterial(\'" 
                        + rsLogon.getString("id")+"\')\" " 
                        + "onclick=\"onClickIncreaseMaterial(\'"
                        + rsLogon.getString("id")+"\')\" >";
//                System.out.println(tmp0);
                tmp += tmp0 +
                       "<td>"+rsLogon.getString("name")+"</td>"+
                       "<td>"+rsLogon.getString("author")+"</td>"+
                       "<td>"+rsLogon.getString("type")+"</td>"+
                       "<td>"+rsLogon.getString("ISBN")+"</td>"+
                       "<td>"+rsLogon.getString("available")+"</td>"+
                       "<td>"+rsLogon.getInt("amount")+"</td>";
                tmp += "</tr>";
            }
            tmp += "</table>";          
            return tmp;
        }		
		catch(Exception e){
			System.out.print("\n fail \n");
			e.printStackTrace();
            System.out.println(e.getMessage()); 
            return null;
		}
		finally { 
		}
    }
}
