/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vjya.userservlets;


import com.vjya.studentapp.Dbcon;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet(name = "userlogin", urlPatterns = {"/userlogin"})
public class userlogin extends HttpServlet {
                   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
				PrintWriter out=null;
                   int p;
                   HttpSession hs=null;
                   String loginstatus=null;
                   String us,pss;
                   RequestDispatcher rd=null;
                   PreparedStatement ps,ps1,ps2;
                      ResultSet rs,rs1,rs2;
    /*
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
           String user=request.getParameter("username");
            String pwd=request.getParameter("password");
            hs=request.getSession(true);
            
           Dbcon dt=new Dbcon();
             
            Class.forName(dt.getDriver());
           Connection cn=DriverManager.getConnection(dt.getUrl(),dt.getUsername(),dt.getPassword());
             
            ps=cn.prepareStatement("select username from Patients where username='"+user+"'");
            ps1=cn.prepareStatement("select pwd from Patients where username='"+user+"'");
            
          rs=ps.executeQuery();
          rs1=ps1.executeQuery();
            if(rs.next()){
                us=rs.getString(1);
                
            }
            
            if(rs1.next()){
                pss=rs1.getString(1);
            }
            
            if(user.equals(us)&& pwd.equals(pss))
            {
              
                ps2=cn.prepareStatement("select patn_id from Patients where username='"+user+"'");
              
                rs2=ps2.executeQuery();
                if(rs2.next()){
                    p=rs2.getInt(1);
                }
                  
                hs.setAttribute("PId", p);
                hs.setAttribute("loginstatus","yes");
              
              
                 out.println("Success");
              
            }
            else
            {
               
                hs.setAttribute("loginstatus","no");
               out.println("Failed");
               
            }
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
                            Logger.getLogger(userlogin.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(userlogin.class.getName()).log(Level.SEVERE, null, ex);
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
                            Logger.getLogger(userlogin.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(userlogin.class.getName()).log(Level.SEVERE, null, ex);
                        }
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
