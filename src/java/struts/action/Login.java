/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import struts.entity.DBMgr;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zsx
 */
public class Login extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username: " + username);
        System.out.println("password: " + password);

        DBMgr dbmr = new DBMgr();
        String[][] para = new String[][]{
            new String[]{"name", "'" + username + "'"},
            new String[]{"password", "'" + password + "'"},};
        ResultSet loginS = dbmr.search("account", para);
        
        try {
            if (loginS.next()) {
                session.setAttribute("username", username);
                session.setAttribute("role", loginS.getString("role"));
                session.setAttribute("loginerrormsg", "");
                System.out.println("login successful");

                ShowAll sa = new ShowAll();
                session.setAttribute("showAllLog", sa.showAllLog());
                session.setAttribute("showAllUser", sa.showAllUser());
                session.setAttribute("showAllRoomReserv", sa.showAllRoomReserv());
                session.setAttribute("showAllMaterialOut", sa.showAllMaterialOut(
                                    (String)session.getAttribute("username")));
                session.setAttribute("showAllMaterial", sa.showAllMaterial());
                session.setAttribute("searchMaterial", "No result found.");       
                
                getServletContext().getRequestDispatcher(
                    "/panel.jsp").forward(request, response);
            } else {
                //errorMessage = "Wrong password.";
                session.setAttribute("loginerrormsg", "Wrong password");
                System.out.println("---Wrong password---");
                
                getServletContext().getRequestDispatcher(
                    "/index.jsp").forward(request, response);
            }
        }
        catch(Exception e){
			System.out.print("\n fail \n");
			e.printStackTrace();
            System.out.println(e.getMessage()); 
            
            getServletContext().getRequestDispatcher(
                    "/index.jsp").forward(request, response);
		}
		finally { 
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
