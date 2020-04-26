/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vjya.beans;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author 
 */
public class DiagnosticsTests implements Serializable{
    public DiagnosticsTests(){
        
    }
    
    private int test_id;
    private String test_name;
    private String test_catg_id;
    private String test_price;
    private String test_method;
    private String test_normalrangefrom;
    private String test_normalrangeto;

    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public String getTest_catg_id() {
        return test_catg_id;
    }

    public void setTest_catg_id(String test_catg_id) {
        this.test_catg_id = test_catg_id;
    }

    public String getTest_price() {
        return test_price;
    }

    public void setTest_price(String test_price) {
        this.test_price = test_price;
    }

    public String getTest_method() {
        return test_method;
    }

    public void setTest_method(String test_method) {
        this.test_method = test_method;
    }

    public String getTest_normalrangefrom() {
        return test_normalrangefrom;
    }

    public void setTest_normalrangefrom(String test_normalrangefrom) {
        this.test_normalrangefrom = test_normalrangefrom;
    }

    public String getTest_normalrangeto() {
        return test_normalrangeto;
    }

    public void setTest_normalrangeto(String test_normalrangeto) {
        this.test_normalrangeto = test_normalrangeto;
    }

   
    
    
    
    
}
