//package Vector;  
  
import java.lang.*;
import java.io.*;
import java.util.*; 
import java.sql.*;
import oracle.jdbc.driver.*;
import oracle.sql.*;
class sid {  
    public static void main(String args[]) {  
        try {  
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:jitendra","scott", "tiger");
             Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

              Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
              Statement stmt3 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String s1;
            String ip2="";
            int cached_hits=0;
	    s1 = "select client_ip,version,user_agent from log_table1 group by(client_ip,version,user_agent)";
            ResultSet rs1 = stmt1.executeQuery(s1);
             String st1="com";
             String st2="google";
             String st3="-";
             int m,n,i,j,k=0;
             
            while (rs1.next()) 
            {   
               Vector a=new Vector();
                
               String temp="";
                String ip1 = rs1.getString("client_ip");
                String version1=rs1.getString("version");
                String user_agent1=rs1.getString("user_agent");
                ResultSet rs2 = stmt2.executeQuery("select * from log_table1 where client_ip='"+ip1+"' and version='"+version1+"' and user_agent='"+user_agent1+"' order by time");
	        while(rs2.next())
                {
                k=0;
                String ref = rs2.getString("referer");
                if(ref.equals("http://www.vnrvjiet.ac.in/"))
                {
                   ref="/Index.asp";
                 } 
                String input = ref;
                String url = rs2.getString("url");
                boolean isMatch1 = input.matches(".*"+st1+".*");
                boolean isMatch2 = input.matches(".*"+st2+".*");
                boolean isMatch3 = input.matches(".*"+st3+".*");
                if(isMatch1||isMatch2||isMatch3)
                {
                  Collection c=new Vector();
                  c.add(url);
                  a.add(new Vector(c));
                }
                else
                {
                  for(i=0;i<a.size();i++)
                  {
                    Vector l=(Vector)a.get(i);
                    for(j=l.size()-1;j>=0;j--)
                    {
                       if(ref.matches(".*"+l.get(j)+".*"))
                        {
         
                          m=j;
                          n=l.size();
                          n=n-1;
                          while(n>m)
                          {
                            cached_hits++;
                            l.add(l.get(n-1));
                            n=n-1;
                          }
                          l.add(url);
                          k=1;
                          break;
                        } 
                     }
                     if(k==1)
                       break;
                   }

                  }

                }
                for(i=0;i<a.size();i++)
                {
                stmt3.executeUpdate("insert into log_table4 values('"+ip1+"','"+a.get(i)+"')");
                 System.out.println(a.get(i)+"\n");
                }          
  
        } 
 System.out.println("total number of cached hits = "+cached_hits+"\n");
}
catch (Exception e) {
System.err.println("Error: " + e.getMessage());
}
    }  
}  