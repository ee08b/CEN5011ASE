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
@WebServlet(name = "ReturnMaterial", urlPatterns = {"/ReturnMaterial"})
public class ReturnMaterial extends HttpServlet {

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
		String name = request.getParameter("name");
        
        System.out.println("name: "+name);
        
    	DBMgr dbmr = new DBMgr();
        String[][] para0 = new String[][]{
    		new String[]{"name", "'"+name+"'"}
        };
        String results = "available = available + 1";
        
        dbmr.delete("material_rsv", para0);
        dbmr.update("material", para0, results);
        System.out.println("return material "+name+" successful");

        ShowAll sa = new ShowAll();
        session.setAttribute("showAllMaterialOut", sa.showAllMaterialOut());
        session.setAttribute("showAllMaterial", sa.showAllMaterial());
        getServletContext().getRequestDispatcher(
                "/panel.jsp").forward(request, response);
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
