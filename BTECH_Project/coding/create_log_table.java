//package arrayList;  
  
import java.lang.*;
import java.io.*;
import java.util.*; 
import java.sql.*;
import oracle.jdbc.driver.*;
import oracle.sql.*;
class create_log_table {  
    public static void main(String args[]) {  
        try {  
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:jitendra","scott", "tiger");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("create table log_table("+"time timestamp,"+"url varchar2(700),"+"client_ip varchar2(20),"+"version varchar2(10),"+"user_agent varchar2(2000),"+"cookie varchar2(2000),"+"referer varchar2(2000),"+"status varchar2(5))");
        
             
  
        } catch (Exception e) {//Catch exception if any  
            System.err.println("Error: " + e.getMessage());  
        }  
    }  
}  