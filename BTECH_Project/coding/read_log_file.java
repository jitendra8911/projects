//package arrayList;  
  
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.DataInputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileReader;  
import java.io.InputStreamReader;  
import java.io.Writer;  
import java.util.ArrayList;  
import java.util.Iterator; 
import java.util.StringTokenizer;
import java.util.List;
 import java.util.Arrays;  
import java.sql.*;
import oracle.jdbc.driver.*;
import oracle.sql.*;
class read_log_file {  
    public static void main(String args[]) {  
        try {  
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:jitendra","scott", "tiger");
            String str=new String();
            String str1=new String();
            Statement stmt = conn.createStatement();
            File file = new File("log.txt");
           String[] record;
           int l=0;
            int i;
            BufferedReader br = new BufferedReader(new FileReader(file));  
            String strLine;  
            //Read File Line By Line  
            while ((strLine = br.readLine()) != null) {
                 l++;
                 if(l>=5)
                 {
                record=strLine.split(" ");
               
                stmt.executeUpdate("insert into log_table values(to_timestamp('"+record[1]+"','HH24:MI:SS'),'"+ record[6]+ "','"+ record[10]+ "','"+ record[11]+ "','"+ record[12]+ "','"+ record[13]+ "','"+ record[14]+ "','" +record[16]+"')");
                 }
 
            }  
            //Close the input stream  
            
             
            
        
             
  
        } catch (Exception e) {//Catch exception if any  
            System.err.println("Error: " + e.getMessage());  
        }  
    }  
}  