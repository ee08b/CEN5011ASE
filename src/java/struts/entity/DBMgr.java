/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.entity;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.Servlet;
//import com.app.struts.action.*;
/**
 *
 * @author zsx
 */
public class DBMgr {
    private String dbConnectUsername = "root";
    private String dbConnectPassword = "root";
    
    public ResultSet display(String table){
        String strSq1 = "select * from "+table;
        System.out.println(strSq1);

        try {          
			Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library";  
            Connection con = DriverManager.getConnection(
                                url,dbConnectUsername,dbConnectPassword); 
			
			Statement st = con.createStatement();  
			ResultSet rsLogon = st.executeQuery(strSq1);   
						
            System.out.println("display successful");
			return rsLogon;   
         }
		catch(Exception e){
			System.out.print("\n fail \n");
            System.out.println(e.getMessage()); 
            ResultSet rsempt = null;
            return rsempt;
		}
    }
    public boolean lookup(String table, String[][] parameters){     
        String conditionString = "";
        
        for (int i=0; i<parameters.length; i++) {
            if (i==0)
                conditionString = (String) parameters[i][0] 
                        + "=" + parameters[i][1];
            else 
                conditionString += (String) " AND "+parameters[i][0] 
                					+ "=" + parameters[i][1];
        }
        
        String strSq1 = "select * from "+table+" where " + conditionString;
        System.out.println(strSq1);

        try {          
			Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library";  
            Connection con = DriverManager.getConnection(
                                url,dbConnectUsername,dbConnectPassword); 
			
			Statement st = con.createStatement();  
			ResultSet rsLogon = st.executeQuery(strSq1);   
			  
			if(rsLogon.next()){
                System.out.println("lookup successful");
				return true;
            }
            else {
                System.out.println("lookup successful");
                return false;
            }
            
         }
		catch(Exception e){
			System.out.print("\n fail \n");
            System.out.println(e.getMessage()); 
            return false;
		}
    }
    
    public ResultSet search(String table, String[][] parameters){
        String conditionString = "";
        
        for (int i=0; i<parameters.length; i++) {
            if (i==0)
                conditionString = (String) parameters[i][0] 
                                    + "=" + parameters[i][1];
            else 
                conditionString += (String) " AND "+parameters[i][0] 
                					+ "=" + parameters[i][1];
        }
        
        String strSq1 = "select * from "+table+" where " + conditionString;
        System.out.println(strSq1);

        try {          
			Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library";  
            Connection con = DriverManager.getConnection(
                                url,dbConnectUsername,dbConnectPassword); 
			
			Statement st = con.createStatement();  
			ResultSet rsLogon = st.executeQuery(strSq1);   
			
            System.out.println("search successful");
			return rsLogon;
         }
		catch(Exception e){
			System.out.print("\n fail \n");
            System.out.println(e.getMessage()); 
            ResultSet rsempt = null;
            return rsempt;
		}
    }
    
    public ResultSet vagueSearch(String table, String[][] parameters){
        String conditionString = "";
        
        for (int i=0; i<parameters.length; i++) {
            if (i==0)
                conditionString = (String) parameters[i][0] 
                                    + " LIKE '%" + parameters[i][1] + "%'";
            else 
                conditionString += (String) " AND "+parameters[i][0] 
                					+ " LIKE '%" + parameters[i][1] + "%'";
        }
        
        String strSq1 = "select * from "+table+" where " + conditionString;
        System.out.println(strSq1);

        try {          
			Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library";  
            Connection con = DriverManager.getConnection(
                                url,dbConnectUsername,dbConnectPassword); 
			
			Statement st = con.createStatement();  
			ResultSet rsLogon = st.executeQuery(strSq1);   
			
            System.out.println("vague search successful");
			return rsLogon;
         }
		catch(Exception e){
			System.out.print("\n fail \n");
            System.out.println(e.getMessage()); 
            ResultSet rsempt = null;
            return rsempt;
		}
    }
    
    public void add(String table, String[][] parameters){
        String parameterString = "";
        String valueString = "";
        
        for (int i=0; i<parameters.length; i++) {
            if (i==0) {
                parameterString += parameters[i][0];
                valueString += parameters[i][1];
            }
            else { 
                parameterString += "," + parameters[i][0];
                valueString += "," + parameters[i][1];
            }
        }
        
        String strSq1 = "insert into " + table + " (" + parameterString 
                        +") values(" + valueString + ")";
        System.out.println(strSq1);

        try {          
			Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library";  
            Connection con = DriverManager.getConnection(
                                url,dbConnectUsername,dbConnectPassword); 
			
			Statement st = con.createStatement();  
			st.executeUpdate(strSq1);   
			System.out.println("add successful");
         }
		catch(Exception e){
			System.out.print("\n fail \n");
            System.out.println(e.getMessage()); 
		}
    }
    
    public void delete(String table, String[][] parameters){
        String conditionString = "";
        
        for (int i=0; i<parameters.length; i++) {
            if (i==0)
                conditionString = (String) parameters[i][0] 
                                    + "=" + parameters[i][1];
            else 
                conditionString += (String) " AND "+parameters[i][0] 
                					+ "=" + parameters[i][1];
        }
        
        String strSq1 = "delete from "+table+" where " + conditionString;
        System.out.println(strSq1);

        try {          
			Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library";  
            Connection con = DriverManager.getConnection(
                                url,dbConnectUsername,dbConnectPassword); 
			
			Statement st = con.createStatement();  
			st.executeUpdate(strSq1);   
			System.out.println("delete successful");
         }
		catch(Exception e){
			System.out.print("\n fail \n");
            System.out.println(e.getMessage()); 
		}
    }
        
    public void update(String table, String[][] parameters, String resultString){
        String conditionString = "";
//        String resultString = "";
        
        for (int i=0; i<parameters.length; i++) {
            if (i==0)
                conditionString = (String) parameters[i][0] 
                                    + "=" + parameters[i][1];
            else 
                conditionString += (String) " AND "+parameters[i][0] 
                					+ "=" + parameters[i][1];
        }
        
//        for (int i=0; i<results.length; i++) {
//            if (i==0)
//                resultString = (String) results[i][0] + "=" + results[i][1];
//            else 
//                resultString += (String) " , "+results[i][0] 
//                					+ "=" + results[i][1];
//        }
        
        String strSq1 = "update " + table + " set " + resultString 
                        +" where " + conditionString;
        System.out.println(strSq1);

        try {          
			Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/library";  
            Connection con = DriverManager.getConnection(
                            url,dbConnectUsername,dbConnectPassword); 
			
			Statement st = con.createStatement();  
			st.executeUpdate(strSq1);   
			System.out.println("update successful");
         }
		catch(Exception e){
			System.out.print("\n fail \n");
            System.out.println(e.getMessage()); 
		}
    }
}
