//package arrayList;  
  
import java.lang.*;
import java.io.*;
import java.util.*; 
import java.sql.*;
import oracle.jdbc.driver.*;
import oracle.sql.*;
class uid1 {  
    public static void main(String args[]) {  
        try {  
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:jitendra","scott", "tiger");
            Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            Statement stmt3 = conn.createStatement();
            String s1;
	    s1 = "select * from log_table2";
            ResultSet rs1 = stmt1.executeQuery(s1);
            while (rs1.next()) 
            {   

               String temp="";
                String ip = rs1.getString("client_ip");
                String cook = rs1.getString("cookie");
                ResultSet rs2 = stmt2.executeQuery("select * from log_table1 where cookie='"+cook+"'");
	        while(rs2.next())
                {
                String ref = rs2.getString("referer");
                String url = rs2.getString("url");
                temp=temp.concat(ref);
                temp=temp.concat("---------->");
                temp=temp.concat(url);
                temp=temp.concat("---------->");
                }
                if(temp.length()<3700)
                stmt3.executeUpdate("insert into log3 values('"+ip+"','"+temp+"')");
              
             }            
  
        } catch (Exception e) {//Catch exception if any  
            System.err.println("Error: " + e.getMessage());  
        }  
    }  
}  