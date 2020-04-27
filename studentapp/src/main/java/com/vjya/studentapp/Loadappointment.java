/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vjya.studentapp;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.*;


/**
 *
 * @author pennantstaff
 */
public class Loadappointment implements Serializable{
     Connection cn=null;
     public Loadappointment(){
          try{
            Dbcon dt=new Dbcon();
             
            Class.forName(dt.getDriver());
            cn=DriverManager.getConnection(dt.getUrl(),dt.getUsername(),dt.getPassword());		
        }catch(Exception ex){
            ex.printStackTrace();
        }
     }
     
     public MakeAppointment makeap(MakeAppointment mk) throws SQLException{
          String qry=null;
            PreparedStatement ps=null;
            CallableStatement cs=null;
            MakeAppointment mka=null;
            try{
                  int apno;
                     cs=cn.prepareCall("{CALL appn_count(?,?,?,?,?,?,?,?,?)}");
                      cs.setInt(1,mk.getDoctorid());
                     cs.setString(2,mk.getPname());
                     cs.setString(3,mk.getPerson());
                      cs.setInt(4,mk.getPid());
                     
                     cs.setObject(5,mk.getSchdate());
                     cs.setString(6,mk.getMode());
                     cs.setString(7,mk.getAmount());
                     cs.setInt(8,mk.getSpecid());
                     cs.registerOutParameter(9,Types.INTEGER);
                     cs.execute();
                     apno=cs.getInt(9);
                     mka=new MakeAppointment();
                     mka.setApno(apno);
                    mka.setAmount(mk.getAmount());
                    mka.setDoctorid(mk.getDoctorid());
                    mka.setMode(mk.getMode());
                    mka.setPerson(mk.getPerson());
                    mka.setPid(mk.getPid());
                    mka.setPname(mk.getPname());
                    mka.setSchdate(mk.getSchdate());
                    mka.setSpecid(mk.getSpecid());
                    mka.setDoctname(mk.getDoctname());
                    mka.setSpecs(mk.getSpecs());
                     return mka;
                     
                     
            } 
            catch(Exception ex){
                ex.printStackTrace();
            }
            return mka;
     }
}
