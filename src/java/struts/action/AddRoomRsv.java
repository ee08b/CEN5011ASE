/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import struts.entity.DBMgr;
/**
 *
 * @author zsx
 */
@WebServlet(name = "AddRoomRsv", urlPatterns = {"/AddRoomRsv"})
public class AddRoomRsv extends HttpServlet {
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();        
        HttpSession session = request.getSession();
		String roomsignup = request.getParameter("roomsignup");        
        String username = (String) session.getAttribute("username");  
		String datesignup = request.getParameter("datesignup");
        String time1signup = request.getParameter("time1signup");  
		String time2signup = request.getParameter("time2signup");
        
        System.out.println("roomsignup: "+roomsignup);
        System.out.println("username: "+username);
        System.out.println("datesignup: "+datesignup);
        System.out.println("time1signup: "+time1signup);
        System.out.println("time2signup: "+time2signup);
        
    	DBMgr dbmr = new DBMgr();
        String condition = "(room = '" + roomsignup + "' AND "
                         + " date = '"+datesignup + "' AND "
                         + " time1 >= '"+time1signup + "') OR "
                         + "(room = '" + roomsignup + "' AND "
                         + " date = '"+datesignup + "' AND"
                         + " time2 <= '"+time2signup + "')";
        ResultSet rsLogon = dbmr.searchCustom("room_rsv", condition);
        
        String[][] para = new String[][]{
    		new String[]{"room", "'"+roomsignup+"'"},
            new String[]{"user", "'"+username+"'"},
    		new String[]{"date", "'"+datesignup+"'"},
            new String[]{"time1", "'"+time1signup+"'"},
            new String[]{"time2", "'"+time2signup+"'"},
    	};
        
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        boolean validRange;
        try {
            validRange = timeFormat.parse(time1signup).before(timeFormat.parse(time2signup));
        }
        catch(Exception e){
			System.out.print("\n fail \n");
			e.printStackTrace();
            System.out.println(e.getMessage()); 
            validRange = false;
		}
        try {
            if (rsLogon.next() || validRange || roomsignup.equals("")) {
                //errorMessage = "user already exists.";
                session.setAttribute("roomreserveerrormsg", "room reserved");
                System.out.println("---room reserved---");

                ShowAll sa = new ShowAll();
                session.setAttribute("showAllRoomReserv", sa.showAllRoomReserv());
                getServletContext().getRequestDispatcher(
                        "/panel.jsp").forward(request, response);
            } else {
                dbmr.add("room_rsv", para);
                session.setAttribute("roomreserveerrormsg", "");
                System.out.println("room reserve successful");

                ShowAll sa = new ShowAll();
                session.setAttribute("showAllRoomReserv", sa.showAllRoomReserv());
                getServletContext().getRequestDispatcher(
                        "/panel.jsp").forward(request, response);
            }
        }
        catch(Exception e){
			System.out.print("\n fail \n");
			e.printStackTrace();
            System.out.println(e.getMessage()); 
		}
		finally { 
            ShowAll sa = new ShowAll();
                session.setAttribute("showAllRoomReserv", sa.showAllRoomReserv());
                getServletContext().getRequestDispatcher(
                        "/panel.jsp").forward(request, response);
		}        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
