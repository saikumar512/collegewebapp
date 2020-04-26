/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.vjya.studentapp.Dbcon;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pennantstaff
 */
@WebServlet(urlPatterns = {"/logoutserv"})
public final class logoutserv extends HttpServlet {
         /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		HttpSession hs=null;
         RequestDispatcher rd=null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                HttpSession hs=null;
                RequestDispatcher rd=null;
                hs=request.getSession(true);
                hs.setAttribute("loginstatus","no");
              int  ns=(Integer)hs.getAttribute("PId");
                   Dbcon dt=new Dbcon();
             
            Class.forName(dt.getDriver());
           Connection cn=DriverManager.getConnection(dt.getUrl(),dt.getUsername(),dt.getPassword());	
             PreparedStatement ps=cn.prepareStatement("update  Patients set PATN_LASTVISIT=sysdate where patn_id="+ns);
             @SuppressWarnings("unused")
			int k=ps.executeUpdate();
                rd=request.getRequestDispatcher("index.html");
                rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             try {
                 processRequest(request, response);
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(logoutserv.class.getName()).log(Level.SEVERE, null, ex);
             } catch (SQLException ex) {
                 Logger.getLogger(logoutserv.class.getName()).log(Level.SEVERE, null, ex);
             }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             try {
                 processRequest(request, response);
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(logoutserv.class.getName()).log(Level.SEVERE, null, ex);
             } catch (SQLException ex) {
                 Logger.getLogger(logoutserv.class.getName()).log(Level.SEVERE, null, ex);
             }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
