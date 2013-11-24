/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddUser", urlPatterns = {"Library/AddUser"})
public class AddUser extends HttpServlet {

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
		String usernamesignup = request.getParameter("usernamesignup");  
		String passwordsignup = request.getParameter("passwordsignup");  
        String rolesignup = request.getParameter("rolesignup");  
        
        System.out.println("usernamesignup: "+usernamesignup);
        System.out.println("passwordsignup: "+passwordsignup);
        System.out.println("rolesignup: "+rolesignup);
        
    	DBMgr dbmr = new DBMgr();
        String[][] para0 = new String[][]{
    		new String[]{"name", "'"+usernamesignup+"'"}
        };
        boolean alreadyExists = dbmr.lookup("account", para0);

        String[][] para = new String[][]{
    		new String[]{"name", "'"+usernamesignup+"'"},
    		new String[]{"password", "'"+passwordsignup+"'"},
            new String[]{"role", "'"+rolesignup+"'"},
    	};
        if (alreadyExists) {
            //errorMessage = "user already exists.";
            session.setAttribute("addusererrormsg", "user already exists");
            System.out.println("---user already exists---");
            getServletContext().getRequestDispatcher(
                    "/panel.jsp").forward(request, response);
        } else {
            dbmr.add("account", para);
            session.setAttribute("addusererrormsg", "");
            System.out.println("add user successful");
            getServletContext().getRequestDispatcher(
                    "/panel.jsp").forward(request, response);
        }
        
        
        
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AddUser</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AddUser at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
