/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.DBConnection;
import pojo.Emp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mehul
 */
public class EmpDao
{
    
    
public static boolean AddEmployee(Emp e) throws SQLException    
{
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("insert into emp  values (?, ?, ?)");
   ps.setInt(1,e.getEno());
   ps.setString(2,e.getEname());
   ps.setDouble(3,e.getSal());
   int count=ps.executeUpdate();
   if (count==1)
       return true;
   else
       return false;
}


public static boolean UpdateEmployee(Emp e) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update emp set ename=?,salary=? where eno=?");
        ps.setString(1,e.getEname());
        ps.setDouble(2,e.getSal());
        ps.setInt(3,e.getEno());
        int count=ps.executeUpdate();
        if(count>0)
          return true;
        else 
            return false;
          
        
    }
    
    public static boolean DeleteEmployee(int e) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("delete from emp where eno=(?)");
        ps.setInt(1,e);
        int count=ps.executeUpdate();
        if(count>0)
          return true;
        else 
            return false;
          
    }
    
   public static ResultSet SearchEmployee(int e) throws SQLException
   {
     
       Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select ename,salary from emp where eno=?");
     ps.setInt(1,e);
        ResultSet rs=ps.executeQuery();
      return rs;
   }
        
    

   
   
   
   public static ArrayList getAllEmployees()  throws SQLException
{
ArrayList<Emp> empList=  new ArrayList();       
Connection conn=DBConnection.getConnection();
Statement st=conn.createStatement();
ResultSet rs=st.executeQuery("select eno,ename,salary from emp");

while(rs.next())
{
Emp e=new Emp();
e.setEno(rs.getInt("eno"));
e.setEname(rs.getString("ename"));
e.setSal(rs.getDouble("salary"));
empList.add(e);
}
return empList;
}
}
        




