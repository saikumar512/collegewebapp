/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vjya.servlets;

import com.vjya.studentapp.Dbcon;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author
 */
@WebServlet(name = "adminlogin", urlPatterns = {"/adminlogin"})
public class adminlogin extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
ResultSet rs=null;
HttpSession hs=null;
String us,pss;
PreparedStatement ps,ps1,ps2;
ResultSet rs1,rs2;
int p;
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
            /* TODO output your page here. You may use following sample code. */
           String user=request.getParameter("username");
            String pwd=request.getParameter("password");
           
               hs=request.getSession(true);
              Dbcon dt=new Dbcon();
             try{
              Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
              Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/vjya","root","root");
             
            ps=con.prepareStatement("select username from admin1 where username='"+user+"'");
            ps1=con.prepareStatement("select pwd from admin1 where pwd='"+pwd+"'");
             
          rs=ps.executeQuery();
         
            if(rs.next()){
                us=rs.getString(1);
                
            }
           
              rs1=ps1.executeQuery();
            if(rs1.next()){
                pss=rs1.getString(1);
            }
       
            if(user.equals(us)&& pwd.equals(pss))
            {
            
                hs.setAttribute("admin","yes");
              
              
                 out.println("Success");
              
            }
            else
            {
               
                hs.setAttribute("admin","no");
               out.println("Failed");
               
            }
            
             
        }
        catch(Exception e)
        {
        	System.out.println(e);
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
        Logger.getLogger(adminlogin.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(adminlogin.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(adminlogin.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(adminlogin.class.getName()).log(Level.SEVERE, null, ex);
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
