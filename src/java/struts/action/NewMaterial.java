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
@WebServlet(name = "NewMaterial", urlPatterns = {"/NewMaterial"})
public class NewMaterial extends HttpServlet {
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
		String materialsignup = request.getParameter("materialsignup");  
		String authorsignup = request.getParameter("authorsignup");  
        String typesignup = request.getParameter("typesignup");  
		String ISBNsignup = request.getParameter("ISBNsignup"); 
        String numbersignup = request.getParameter("numbersignup");  
        
        System.out.println("materialsignup: "+materialsignup);
        System.out.println("authorsignup: "+authorsignup);
        System.out.println("typesignup: "+typesignup);
        System.out.println("ISBNsignup: "+ISBNsignup);
        System.out.println("numbersignup: "+numbersignup);
        
    	DBMgr dbmr = new DBMgr();
        String[][] para0 = new String[][]{
    		new String[]{"name", "'"+materialsignup+"'"}
        };
        boolean alreadyExists = dbmr.lookup("material", para0);
        
        boolean amountIsInt = isInteger(numbersignup);
        boolean ISBNIsInt = isInteger(ISBNsignup);
        System.out.println("amount is int:"+amountIsInt+"; ISBN is int:"+ISBNIsInt);
        
        String[][] para = new String[][]{
    		new String[]{"name", "'"+materialsignup+"'"},
    		new String[]{"author", "'"+authorsignup+"'"},
            new String[]{"type", "'"+typesignup+"'"},
            new String[]{"ISBN", "'"+ISBNsignup+"'"},
            new String[]{"available", "'"+numbersignup+"'"},
            new String[]{"amount", "'"+numbersignup+"'"},
    	};
        if(!amountIsInt) {
            session.setAttribute("addmaterialerrormsg", "amount is not an integer");
        } else
        if(!ISBNIsInt) {
            session.setAttribute("addmaterialerrormsg", "ISBN is not an integer");
        } else
        if (alreadyExists) {
            //errorMessage = "user already exists.";            
            session.setAttribute("addmaterialerrormsg", "material already exists");
            System.out.println("---material already exists---");
        } else {
            dbmr.add("material", para);
            session.setAttribute("addusererrormsg", "");
            System.out.println("add material successful");         
        }
        ShowAll sa = new ShowAll();
        session.setAttribute("showAllMaterial", sa.showAllMaterial());
        getServletContext().getRequestDispatcher(
                    "/panel.jsp").forward(request, response);
    }
    
    public static boolean isInteger(String s) {
        try {  
            System.out.println("convert to int"+Integer.parseInt(s)); 
        }  
        catch(NumberFormatException nfe) {  
            return false;  
        }  
        return true;  
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
