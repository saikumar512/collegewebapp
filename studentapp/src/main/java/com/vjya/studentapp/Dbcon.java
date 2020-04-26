package com.vjya.studentapp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author
 */
public class Dbcon implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getDriver() {
        return driver;
    }
    private String driver;
    private String url;
    private String username;
        private String password;
    
    public Dbcon() throws FileNotFoundException, IOException{
           FileReader f=new FileReader("C:\\Users\\ksaik\\vijaya\\studentapp\\configure.properties");
                     Properties prop = new Properties();
                     prop.load(f);
                     driver=prop.getProperty("jdbc.driver");
                     url=prop.getProperty("jdbc.url");
                     username=prop.getProperty("jdbc.username");
                     password=prop.getProperty("jdbc.password");
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    
}
