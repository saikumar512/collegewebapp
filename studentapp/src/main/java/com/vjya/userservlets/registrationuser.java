/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vjya.userservlets;


import com.vjya.studentapp.Dbcon;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pennantstaff
 */
@WebServlet(name = "registrationuser", urlPatterns = {"/registrationuser"})
public class registrationuser extends HttpServlet {
              PreparedStatement ps,ps1;
               ResultSet rs;
               int i;
                int random3;
              
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
   
                for(int j=0;j<5;j++){
              random3 =(int)Math.floor(Math.random()*100)+1;
                }
                    
             
           String user=request.getParameter("username");
           String password=request.getParameter("password");
        
           
           
         
           if(user!=null||password!=null){
                 String vuser=null;
          Dbcon dt=new Dbcon();
             
            Class.forName(dt.getDriver());
           Connection cn=DriverManager.getConnection(dt.getUrl(),dt.getUsername(),dt.getPassword());
         ps=cn.prepareStatement("select username from Patients where username='"+user+"'");
        
            rs=ps.executeQuery();
          
             
             if(rs.next()){
                 vuser=rs.getString("username");
                 out.println("UserName Alredy Exsits you can use : "+vuser+""+random3);
                 
             }else{
           CallableStatement stmt=cn.prepareCall("{call addPatient(?,?)}");  
           stmt.setString(1,user);  
            stmt.setString(2,password);  
            stmt.execute();  
                out.println("Registration Successfull");
             }
              
           }
           else{
               out.println("Enter username and password");
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
                      Logger.getLogger(registrationuser.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (SQLException ex) {
                      Logger.getLogger(registrationuser.class.getName()).log(Level.SEVERE, null, ex);
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
                      Logger.getLogger(registrationuser.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (SQLException ex) {
                      Logger.getLogger(registrationuser.class.getName()).log(Level.SEVERE, null, ex);
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
