/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;
import java.util.*;
import java.text.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
@WebServlet(name = "BorrowMaterial", urlPatterns = {"/BorrowMaterial"})
public class BorrowMaterial extends HttpServlet {
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
        //System.out.println("id: "+id);
        
    	DBMgr dbmr = new DBMgr();
        String[][] para0 = new String[][]{
    		new String[]{"name", "'"+name+"'"}
        };
        String results = "available = available - 1";
        ResultSet rsLogon = dbmr.search("material", para0);
        
        ResultSet rsLogon1 = dbmr.search("material_rsv", para0);
        //rsLogon.next();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        
        try{
            if(rsLogon.next() && !rsLogon1.next() && rsLogon.getInt("available") > 0) {
                String[][] para1 = new String[][]{
                    new String[]{"name", "'"+name+"'"},
                };
                dbmr.update("material", para1, results);                
                
                String[][] para = new String[][]{
                    new String[]{"name", "'"+name+"'"},
                    new String[]{"user", "'"+(String) session.getAttribute("username")+"'"},
                    new String[]{"date","'"+dateFormat.format(new Date())+"'"},
                    new String[]{"time","'"+timeFormat.format(new Date())+"'"},
                };

                dbmr.add("material_rsv", para);
                System.out.println("borrow material "+name+" successful");
            } else {
                
            }
        }
        catch(Exception e){
			System.out.print("\n fail \n");
			e.printStackTrace();
            System.out.println(e.getMessage()); 
		}
		finally { 
		}
        

        ShowAll sa = new ShowAll();
        session.setAttribute("showAllMaterial", sa.showAllMaterial());
        session.setAttribute("showAllMaterialOut", sa.showAllMaterialOut());
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
