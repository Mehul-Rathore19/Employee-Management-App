/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author mehul
 */
public class LoginDao {
    
    Connection conn;
PreparedStatement ps;
          ResultSet rs;



      public ResultSet AdminLogin(String username,String password) throws Exception {
      
       
 
           conn=DBConnection.getConnection();
             ps=conn.prepareStatement("select * from adminlogin where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
   
         rs=ps.executeQuery();
         
         
        return rs; 
      }

      
            public ResultSet ManagerLogin(String username,String password) throws Exception {
      
       
 
           conn=DBConnection.getConnection();
             ps=conn.prepareStatement("select * from managerlogin where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
   
         rs=ps.executeQuery();
         
         
        return rs; 
      }
}