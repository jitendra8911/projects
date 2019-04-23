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
class FileRead1 {  
    public static void main(String args[]) {  
        try {  
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:jitendra","scott", "tiger");
            String str=new String();
            String str1=new String();
            Statement stmt = conn.createStatement();
            File file = new File("sample1.txt");
          ArrayList list=new ArrayList();
           list.add("1"); list.add("6"); list.add("10"); list.add("11"); list.add("12"); list.add("3"); list.add("14"); list.add("16");
           String[] record;
           int w=0;
            int l=0;
          /* list.add("time");
           list.add("cs-uri-stem");		 
           list.add("c-ip");
           list.add("cs-version");
           list.add("cs(User-Agent)");
            list.add("cs(Cookie)");
           list.add("cs(Referer)");
           list.add("sc-status");
            BufferedReader br = new BufferedReader(new FileReader(file));  
            String strLine;  
            //Read File Line By Line  
            while ((strLine = br.readLine()) != null) {
                 l++;
                 if(l>=5)
                 {
                record=strLine.split(" ");
                for(i=0;i<record.length;i++)
                {
                  if(w>=1)
                   {
                     for (Iterator iter = List.iterator(); iter.hasNext();)
                     {
                       
                        str=(String)iter.next();
                        if(w==(Integer.parseInt(str)))
                  
            }  
            //Close the input stream  
            
             */
             stmt.executeUpdate("create table log_info("+"time varchar2(10),"+"url varchar2(700),"+"client_ip varchar2(20),"+"version varchar2(10),"+"user_agent varchar2(700),"+"cookie varchar2(700),"+"referer varchar2(700),"+"status varchar2(5))");
        
             
  
        } catch (Exception e) {//Catch exception if any  
            System.err.println("Error: " + e.getMessage());  
        }  
    }  
}  