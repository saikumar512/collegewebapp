/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vjya.studentapp;

import java.io.Serializable;

import java.sql.Date;
import java.util.logging.Logger;


/**
 *
 * @author
 */
public class MakeAppointment implements Serializable {
    private int apno;
    private int pid;
    private int specid;
     private int doctorid;
    private String pname;
    private String person;
    private  Date schdate;
    private String amount;
    private String doctname;
    private String specs;
 private String mode;
    
      public void setDoctname(String doctname) {
        this.doctname = doctname;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

     public String getDoctname() {
        return doctname;
    }

    public String getSpecs() {
        return specs;
    }
    public int getApno() {
        return apno;
    }

    public int getPid() {
        return pid;
    }

    public void setApno(int apno) {
        this.apno = apno;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setSpecid(int specid) {
        this.specid = specid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public void setSchdate(Date schdate) {
        this.schdate = schdate;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getSpecid() {
        return specid;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public String getPname() {
        return pname;
    }

    public String getPerson() {
        return person;
    }

    public Date getSchdate() {
        return schdate;
    }

    public String getAmount() {
        return amount;
    }

    public String getMode() {
        return mode;
    }
   

    
    public MakeAppointment(){
        apno=11;
        pid=12;
        specid=12;
        doctorid=12;
        pname="Rahul";
        person="Self";
        amount="200INR";
        mode="netBanking";
    }
     public MakeAppointment(int an,int patid,int sid,int did,String patname,String pson,Date scd,String amnt,String md){
        apno=an;
        pid=patid;
        specid=sid;
        doctorid=did;
        pname=patname;
        person=pson;
        schdate=scd;
        amount=amnt;
        mode=md;
              
    }
}
     
  