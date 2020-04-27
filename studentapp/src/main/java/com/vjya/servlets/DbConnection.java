/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vjya.servlets;

import com.vjya.beans.DiagnosticsTests;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;

/**
 *
 * @author 
 */
@WebServlet(name = "DbConnection", urlPatterns = {"/DbConnection"})
public class DbConnection {
    
 private static final String PROPERTY_FILENAME = "C:\\Users\\ksaik\\vijaya\\studentapp\\configure.properties";
	private static final Properties properties=new Properties();
	
	public static String getProperty (String property){
		//if (properties == null) {
			loadProperties();
			if (properties == null) {
				return null;
			}
		String retStr = properties.getProperty(property);
		return retStr;
	}
	private static void loadProperties() {
		InputStream input = null;

		try {	
                     properties.load(new FileInputStream(PROPERTY_FILENAME));
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
