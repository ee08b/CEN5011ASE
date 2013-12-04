/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struts.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Date;
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
@WebServlet(name = "MaterialAmount", urlPatterns = {"/MaterialAmount"})
public class MaterialAmount extends HttpServlet {

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
		String id = request.getParameter("id");
        String type = request.getParameter("type");
        String results;                    

        DBMgr dbmr = new DBMgr();
        String[][] para0 = new String[][]{
    		new String[]{"id", "'"+id+"'"},
        };        
        ResultSet rsLogon;
        try{
            if(type.equals("increase")){
                results = "amount = amount + 1, available = available + 1";
                dbmr.update("material", para0, results);
                System.out.println("increase material "+id+" successful");
            } else if(type.equals("reduce")){
//                rsLogon = dbmr.search("material", para0);
//                
//                String[][] para1;
//                if(rsLogon.next()) {
//                    System.out.println("material id="+id+" name="+rsLogon.getString("name")+" found "
//                            + rsLogon.getInt("amount") +" left. ");
//                    
//                    para1 = new String[][]{
//                            new String[]{"name", "'"+rsLogon.getString("name")+"'"},
//                        };
//
//                    ResultSet rsLogon1 = dbmr.search("material_rsv", para1);
//                    if(rsLogon1.next()) {  
//                        System.out.println("material "+id+" has "+rsLogon.getInt("amount")+" left. ");
//                        
//                        if(!rsLogon1.next() && rsLogon.getInt("amount") <= 0) {
//                            dbmr.delete("material", para0);
//                            System.out.println("material "+id+" delete successful");
//                        } else {
                            results = "amount = amount - 1, available = available - 1";
                            dbmr.update("material", para0, results);
                            
                            rsLogon = dbmr.search("material", para0);
                            if(rsLogon.next() && rsLogon.getInt("available") < 0){
                                if(rsLogon.getInt("amount") < 0) {
                                        dbmr.delete("material", para0);
                                }else {
                                    results = "amount = amount + 1, available = available + 1";
                                    dbmr.update("material", para0, results);
                                }
                            }
//                            System.out.println("material "+id+" has "+rsLogon.getInt("amount")
//                                                +", reduced successful");
//                        }
//                    }
//                }
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
