/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;

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
@WebServlet(name = "SearchMaterial", urlPatterns = {"/SearchMaterial"})
public class SearchMaterial extends HttpServlet {

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
		String materialSearch = request.getParameter("materialSearch");  
		String authorSearch = request.getParameter("authorSearch");  
        String typeSearch = request.getParameter("typeSearch");  
        String ISBNSearch = request.getParameter("ISBNSearch");  
        String numberSearch = request.getParameter("numberSearch");  
        
        System.out.println("materialSearch: "+materialSearch);
        System.out.println("authorSearch: "+authorSearch);
        System.out.println("typeSearch: "+typeSearch);
        System.out.println("ISBNSearch: "+ISBNSearch);
        System.out.println("numberSearch: "+numberSearch);
        
    	DBMgr dbmr = new DBMgr();
        String[][] para = new String[][]{
    		new String[]{"name", materialSearch},
    		new String[]{"author", authorSearch},
            new String[]{"type", typeSearch},
            new String[]{"ISBN", ISBNSearch},
            new String[]{"available", numberSearch},
    	};

        ResultSet rsLogon = dbmr.vagueSearch("material", para);
        session.setAttribute("search_material_errormsg", "");
        System.out.println("search material successful");
        
        try {
            String tmp = "<table border=0 width=100%><tr>"
                    + "<td>material</td>"
                    + "<td>author</td>"
                    + "<td>type</td>"
                    + "<td>ISBN</td>"
                    + "<td>available</td>"
                    + "</tr>";
        //    if (rsLogon.first()) {
                while (rsLogon.next()) {
                        tmp += "<tr ondblclick=\"dbclickBorrowMaterial(\'"
                            + rsLogon.getString("name") + "\')\">"
                            + "<td>" + rsLogon.getString("name") + "</td>"
                            + "<td>" + rsLogon.getString("author") + "</td>"
                            + "<td>" + rsLogon.getString("type") + "</td>"
                            + "<td>" + rsLogon.getString("ISBN") + "</td>"
                            + "<td>" + rsLogon.getInt("available") + "</td>";
                        tmp += "</tr>";
                }
                tmp += "</table>";
//            } else {
//                tmp = "No result found. ";
//            }
            //No result found.
            session.setAttribute("searchMaterial", tmp);
            System.out.println("search material: "+tmp);
            
            ShowAll sa = new ShowAll();
            sa.showAllMaterialOut();
            sa.showAllMaterial();
            getServletContext().getRequestDispatcher(
                    "/panel.jsp").forward(request, response);     
        }		
		catch(Exception e){
			System.out.print("\n fail \n");
			e.printStackTrace();
            System.out.println(e.getMessage()); 
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
