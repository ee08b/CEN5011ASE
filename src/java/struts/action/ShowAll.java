/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import java.sql.ResultSet;
import struts.entity.DBMgr;

/**
 *
 * @author zsx
 */
public class ShowAll {
    
    public String showAllLog (){
        DBMgr dbmr = new DBMgr();    	
    	ResultSet rsLogon = dbmr.display("log");
        try {
            String tmp = "<table border=0 width=100>";
            while (rsLogon.next()){
                tmp += "<tr>";
                tmp += "<td>"+rsLogon.getString("user")+"<td>"+
                       "<td>"+rsLogon.getString("name")+"<td>"+
                       "<td>"+rsLogon.getString("type")+"<td>"+
                       "<td>"+rsLogon.getString("action")+"<td>"+
                       "<td>"+rsLogon.getString("date")+"<td>"+
                       "<td>"+rsLogon.getString("time")+"<td>";
                //"<td>"++"<td>"+
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
    
    public String showAllUser (){
        DBMgr dbmr = new DBMgr();    	
    	ResultSet rsLogon = dbmr.display("account");
        try {
            String tmp = "";
            while (rsLogon.next()){
                tmp += "<dl class=\"sort\"><dt><table border=0 width=\"100%\"><tr>";
                tmp += "<td width=\"300px\">"+rsLogon.getString("name")+"<td>"+
                       "<td width=\"300px\">"+rsLogon.getString("password")+"<td>"+
                       "<td>"+rsLogon.getString("role")+"<td>";
                tmp += "</tr></table></dt></dl>";
            }
            tmp += "";
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
            String tmp = "";
            while (rsLogon.next()){
                tmp += "<dl class=\"sort\"><dt><table border=0 width=100><tr>";
                tmp += "<td>"+rsLogon.getString("room")+"<td>"+
                       "<td>"+rsLogon.getString("user")+"<td>"+
                       "<td>"+rsLogon.getDate("date")+"<td>"+
                       "<td>"+rsLogon.getTime("time1")+"<td>"+
                       "<td>"+rsLogon.getTime("time2")+"<td>";
                tmp += "</tr></table></dt></dl>";
            }
            tmp += "";
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
        
    public String showAllMaterialOut (){
        DBMgr dbmr = new DBMgr();    	
    	ResultSet rsLogon = dbmr.display("material_rsv");
        try {
            String tmp = "";
            while (rsLogon.next()){
                tmp += "<dl class=\"sort\"><dt><table border=0 width=100><tr>";
                tmp += "<td>"+rsLogon.getString("name")+"<td>"+
                       "<td>"+rsLogon.getString("user")+"<td>"+
                       "<td>"+rsLogon.getDate("date")+"<td>"+
                       "<td>"+rsLogon.getTime("time")+"<td>";
                tmp += "</tr></table></dt></dl>";
            }
            tmp += "";
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
            String tmp = "";
            while (rsLogon.next()){
                tmp += "<dl class=\"sort\"><dt><table border=\"0\" width=\"100%\" style=\"font-size:\"2\";\"><tr>";
                tmp += "<td width=\"200px\">"+rsLogon.getString("name")+"<td>"+
                       "<td width=\"180px\">"+rsLogon.getString("author")+"<td>"+
                       "<td width=\"40px\">"+rsLogon.getString("type")+"<td>"+
                       "<td width=\"50px\">"+rsLogon.getString("ISBN")+"<td>"+
                       "<td width=\"20px\">"+rsLogon.getInt("available")+"<td>";
                tmp += "</tr></table></dt></dl>";
            }
            tmp += "";
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
