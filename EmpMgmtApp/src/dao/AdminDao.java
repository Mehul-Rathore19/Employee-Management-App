/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pojo.Manager;

/**
 *
 * @author mehul
 */
public class AdminDao {
    
    public static boolean AddManager(Manager m) throws SQLException    
{
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("insert into managerlogin values (?,?)");
   ps.setString(1,m.getUsername());
   ps.setString(2,m.getPassword());
   
   int count=ps.executeUpdate();
   if (count==1)
       return true;
   else
       return false;
}

    
}
