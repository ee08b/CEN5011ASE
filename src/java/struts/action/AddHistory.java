/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import struts.entity.DBMgr;

/**
 *
 * @author zsx
 */
public class AddHistory {
    public void addRecord(String username, String name, String type, String action) {
        DBMgr dbmr = new DBMgr();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        
        String[][] para = new String[][]{
    		new String[]{"user", "'"+username+"'"},
    		new String[]{"name", "'"+name+"'"},
            new String[]{"type", "'"+type+"'"},
            new String[]{"action", "'"+action+"'"},
            new String[]{"date", "'"+dateFormat.format(new Date())+"'"},
            new String[]{"time", "'"+timeFormat.format(new Date())+"'"},
    	};
                
        dbmr.add("log", para);        
    }
}
