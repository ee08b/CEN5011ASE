/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import struts.entity.DBMgr;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zsx
 */
public class LoginServlet extends HttpServlet {

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
        
        System.out.println("username: "+username);
        System.out.println("password: "+password);
        
        DBMgr dbmr = new DBMgr();
    	String[][] para = new String[][]{
    		new String[]{"name", "'"+username+"'"},
    		new String[]{"password", "'"+password+"'"},
    	};    	
    	boolean loginS = dbmr.lookup("account", para);
        
        if(loginS) {
            session.setAttribute("username", username);
        }
        else {
        //errorMessage = "Wrong password.";
            getServletContext().getRequestDispatcher(
								"/index.jsp").forward(request, response);
        }
            
  
        
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
////            /* TODO output your page here. You may use following sample code. */
////            out.println("<!DOCTYPE html>");
////            out.println("<html>");
////            out.println("<head>");
////            out.println("<title>Servlet LoginServlet</title>");            
////            out.println("</head>");
////            out.println("<body>");
////            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
////            out.println("</body>");
////            out.println("</html>");
//        } finally {            
//            out.close();
//        }
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
