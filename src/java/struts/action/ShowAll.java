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
            String tmp = "<table border=0>";
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
            String tmp = "<table border=0>";
            while (rsLogon.next()){
                tmp += "<tr>";
                tmp += "<td>"+rsLogon.getString("name")+"<td>"+
                       "<td>"+rsLogon.getString("role")+"<td>";
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
}
