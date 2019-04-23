import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
class SplitPane2 extends JFrame implements ActionListener
{
	private		JSplitPane	splitPaneV;
	private		JSplitPane	splitPaneH;
                 private		JSplitPane                 vertical;
                 private		JSplitPane                 vertical1;
	private		JPanel		panel1;
	private		JPanel		panel2;
	private		JPanel		panel3;
                 private		JPanel		headingpanel;
                 private		JPanel		buttonpanel;
                 private                       JEditorPane               link;
                 private                       JEditorPane               display;
                 private                        JTextField                  field;

                 int             cached_hits=0;


	public SplitPane2()
	{
		setTitle( "Web Usage Mining by Jitendra , Rakesh E , Pavan,Vamshi" );
		setBackground( Color.gray );
                setBackground( Color.gray );
		JPanel topPanel = new JPanel();
                
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		// Create the panels
		createPanel1();
		createPanel2();
		createPanel3();
                                  createbuttonPanel();
                                  createheadingPanel();
		// Create a splitter pane
		splitPaneV = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
		topPanel.add( splitPaneV,BorderLayout.CENTER );
                                       
		splitPaneH = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
                                    vertical = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
                                    vertical1 = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
                                   vertical.setDividerLocation(30);
                                    vertical1.setDividerLocation(30);
		
                                   splitPaneH.setLeftComponent( vertical);
                                   splitPaneH.setDividerLocation(220);
		splitPaneH.setRightComponent( vertical1);
                                   vertical.setLeftComponent(buttonpanel);
		vertical.setRightComponent(panel2);
                                    vertical1.setLeftComponent(headingpanel);
                                    vertical1.setRightComponent(panel3);
		splitPaneV.setLeftComponent(panel1);
		splitPaneV.setRightComponent( splitPaneH );
}

	public void createPanel2()
	{
		panel2 = new JPanel();
		panel2.setLayout( new BorderLayout() );
                                  link=new JEditorPane();
                                  link.setContentType("text/html");
                                   link.setEditable(false);   
                                  link.setText("<html><body bgcolor=\"#ffffcc\"><A HREF=\"cleaning\"><img src=\"file:///F:/4-2 project/modified_final project/coding/cleaning.png\" width=100px ></A><br><A HREF=\"users\"><img src=\"file:///E:/coding/users.png\" width=100px ></A><br><A HREF=\"sessions\"><img src=\"file:///F:/4-2 project/modified_final project/coding/sessions.png\" width=100px ></A><br><A HREF=\"general\"><img src=\"file:///F:/4-2 project/modified_final project/coding/general.png\" width=100px ></A><br><A HREF=\"status_report\"><img src=\"file:///F:/4-2 project/modified_final project/coding/statusreport.png\" width=100px ></A><br><A HREF=\"association\"><img src=\"file:///F:/4-2 project/modified_final project/coding/association.jpg\" width=100px ></A></body></html>");
                                 
                                  link.addHyperlinkListener(new HyperlinkListener() {
      public void hyperlinkUpdate(HyperlinkEvent e) {
	// Handle clicks; ignore mouseovers and other link-related events
	if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
	  // Get the HREF of the link and display it.

    if(e.getDescription().equals("cleaning")) 
                    {
	  display.setText(cleaning());
                     } 
     if(e.getDescription().equals("users")) 
                    {
	  display.setText(get_users());
                     } 
     if(e.getDescription().equals("sessions")) 
                    {
	  display.setText(get_sessions());
                     } 
                    if(e.getDescription().equals("general")) 
                    {
	  display.setText(general());
                     }   
     if(e.getDescription().equals("status_report")) 
                    {
	  display.setText(status_report());
                     } 
     if(e.getDescription().equals("association")) 
                    {
	  display.setText(apriory());
                     } 

	}
      }
    });

		// Add some buttons
		//panel1.add( new JButton( "North" ), BorderLayout.NORTH );
		//panel1.add( new JButton( "South" ), BorderLayout.SOUTH );
		//panel1.add( new JButton( "East" ), BorderLayout.EAST );
		//panel1.add( new JButton( "West" ), BorderLayout.WEST );
		panel2.add( link, BorderLayout.CENTER );

	}
                 
                 public void createbuttonPanel()
	{
		buttonpanel = new JPanel();
		buttonpanel.setLayout( new BorderLayout() );
                                   JButton browse=new JButton( "Browse" );
		// Add some buttons
                                  browse.addActionListener(this);
                                  field=new JTextField(10);
		buttonpanel.add( browse, BorderLayout.EAST );
		//panel1.add( new JButton( "South" ), BorderLayout.SOUTH );
		//panel1.add( new JButton( "East" ), BorderLayout.EAST );
		//panel1.add( new JButton( "West" ), BorderLayout.WEST );
		buttonpanel.add(field , BorderLayout.CENTER );

	}


	public void createPanel3()
	{
		panel3 = new JPanel();
		panel3.setLayout( new BorderLayout() );
                                  display= new JEditorPane( ); 
                                  JScrollPane scroller=new JScrollPane(display);
                                    display.setContentType("text/html");
                                       
                                   display.setText("<html><body bgcolor=\"#ffffcc\"><font color=\"red\" size=12  face=\"verdana\" ><br><br><br><center>Welcome to Web Miner</font></body></html>");
		panel3.add( scroller, BorderLayout.CENTER );
		//panel2.add( new JButton( "Button 2" ) );
		//panel2.add( new JButton( "Button 3" ) );
	}

	public void createPanel1()
	{
		panel1 = new JPanel();
		panel1.setLayout( new BorderLayout() );
        //panel3.setPreferredSize( new Dimension( 400, 100 ) );
       // panel3.setMinimumSize( new Dimension( 100, 50 ) );
        ImageIcon i1=new ImageIcon("C:\\webminingcode\\javacode\\vjiet.gif");
      JLabel logo=new JLabel(i1);
      JLabel title=new JLabel("<html><font color=\"blue\" size=12  face=\"verdana\" >web usage mining</font></html>");    //title of project
		//panel3.add( logo);
		//panel3.add( title);
                               panel1.add( logo, BorderLayout.WEST);
                               panel1.add( title, BorderLayout.CENTER);
	}


                public void createheadingPanel()
	{
                       headingpanel=new JPanel();
                       // headingpanel.setLayout( new BorderLayout() );
                        JLabel head=new JLabel("<html><font color=\"green\" size=12  face=\"verdana\" >preprocessing application</font></html>");    
                         //headingpanel.add(head, BorderLayout.CENTER);
                          headingpanel.add(head);
                 }

                



 public void actionPerformed(ActionEvent ae)                        //event handling method
                      {
                               Chooser frame = new Chooser();                         //object for file choosing
                              field.setText(frame.fileName);
                             String f1=field.getText();
  try  {                                                            //database connection
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:jitendra","scott", "tiger");
            String str=new String();
            String str1=new String();
            Statement stmt = conn.createStatement();
            File file = new File(f1);
           String[] record;
           int l=0;
            int i;
            BufferedReader br = new BufferedReader(new FileReader(file));  
            String strLine;  
            //Read File Line By Line  
            while ((strLine = br.readLine()) != null) 
               {
                     l++;
                     if(l>=5)
                 {
                   record=strLine.split(" ");
               
                   stmt.executeUpdate("insert into log_information values(to_date('"+record[0]+"','yyyy-mm-dd'),"+"to_timestamp('"+record[1]+"','HH24:MI:SS'),'"+ record[6]+ "','"+ record[10]+ "','"+ record[11]+ "','"+ record[12]+ "','"+ record[13]+ "','"+ record[14]+ "','" +record[16]+"')");
                 }
               }
         conn.close();
        }

 catch (Exception e)
                {                                                     //Catch exception if any  
                      System.err.println("Error: " + e.getMessage());  
                } 
   
}

     





             public String cleaning()
              {
                StringWriter sout = new StringWriter();
                PrintWriter out = new PrintWriter(sout);
try{
               Class.forName("oracle.jdbc.driver.OracleDriver");
               Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:jitendra","scott", "tiger");
                Statement stmt = conn.createStatement();
               String str1="delete from data_cleaning";
               String str2="insert into data_cleaning select distinct * from log_information where url not like '%jpg' and url not like '%png' and url not like '%gif' and url not like '/robots.txt'  and url not like '%.GIF' and url not like '%.css' and url not like '%.js' and url not like '%.JPG' and url not like '%.PNG' and url not like '%favicon%' and user_agent not like '%.com%'";
               stmt.executeUpdate(str1);
               stmt.executeUpdate(str2);
               String str3="select distinct * from data_cleaning";
               ResultSet rs=stmt.executeQuery(str3);
               out.println("<html><body bgcolor=\"#ffffcc\"><table border=\"1\"><tr><th>TIME</th><th>URL</th><th>CLIENT IP</th><th>VERSION</th><th>USER AGENT</th><th>COOKIE</th><th>REFERER</th><th>STATUS</th></tr>");
               while(rs.next())
               {
                  out.println("<tr><td>"+rs.getString("time")+"</td><td>"+rs.getString("url")+"</td><td>"+rs.getString("client_ip")+"</td><td>"+rs.getString("version")+"</td><td>"+rs.getString("user_agent")+"</td><td>"+rs.getString("cookie")+"</td><td>"+rs.getString("referer")+"</td><td>"+rs.getString("status")+"</td></tr>");
               }
               out.println("</table></body></html>");
               out.close();
               conn.close();


}
 catch (Exception e)
                {                                                     //Catch exception if any  
                      System.err.println("Error: " + e.getMessage());  
                } 
 return sout.toString();
}











public String get_users()
      {
          

            StringWriter sout = new StringWriter();
            PrintWriter out = new PrintWriter(sout);

            try {
             
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:jitendra","scott", "tiger");
             Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

              Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
              Statement stmt3 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String s1;
            String ip2="";
            s1="select client_ip,user_agent,version,cookie from data_cleaning group by(client_ip,user_agent,version,cookie) having cookie<>'-'";
	    
            stmt1.executeUpdate("delete from users_path");
            ResultSet rs1 = stmt1.executeQuery(s1);
            while (rs1.next()) 
            {   
              
               String temp="";
                String ip1 = rs1.getString("client_ip");
                String cook = rs1.getString("cookie");
                ResultSet rs2 = stmt2.executeQuery("select * from data_cleaning where cookie='"+cook+"'");
	        while(rs2.next())
                {
                //String ref = rs2.getString("referer");
                String url = rs2.getString("url");
                //temp=temp.concat(ref);
                 ip2 = rs2.getString("client_ip");
                if(ip2.equals(ip1))
                {
                temp=temp.concat(url);
                temp=temp.concat("---------->");
                 }
                }
                if(temp.length()<3700)
                stmt3.executeUpdate("insert into users_path values('"+ip1+"','"+temp+"')");
                          
  
             } 

             
             s1="select * from users_path";
            rs1=stmt1.executeQuery(s1);
               out.println("<html><body bgcolor=\"#ffffcc\"><table border=\"1\"><tr><th>client_ip</th><th>path</th></tr>");
               while(rs1.next())
               {
                  out.println("<tr><td>"+rs1.getString("client_ip")+"</td><td>"+rs1.getString("path")+"</td></tr>");
               }
               out.println("</table></body></html>");
               out.close();
               conn.close();
      }

    catch (Exception e) {
     System.err.println("Error: " + e.getMessage()); 
                         }

return sout.toString();
      
} 







public  String get_sessions() {  

        StringWriter sout = new StringWriter();
        PrintWriter out = new PrintWriter(sout);

        try {  
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:jitendra","scott", "tiger");
             Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

              Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
              Statement stmt3 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String s1;
            String ip2="";
            
            stmt1.executeUpdate("delete from sessions");
	    s1 = "select client_ip,version,user_agent from data_cleaning group by(client_ip,version,user_agent)";
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
                ResultSet rs2 = stmt2.executeQuery("select * from data_cleaning where client_ip='"+ip1+"' and version='"+version1+"' and user_agent='"+user_agent1+"' order by time");
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
                stmt3.executeUpdate("insert into sessions values('"+ip1+"','"+a.get(i)+"')");
                 
                }          
  
        } 


            s1="select * from sessions";
            rs1=stmt1.executeQuery(s1);
               out.println("<html><body bgcolor=\"#ffffcc\"><table border=\"1\"><tr><th>client_ip</th><th>path</th></tr>");
               while(rs1.next())
               {
                  out.println("<tr><td>"+rs1.getString("client_ip")+"</td><td>"+rs1.getString("path")+"</td></tr>");
               }
               out.println("</table></body></html>");
               out.close();
               conn.close();


           System.out.println("total number of cached hits = "+cached_hits+"\n");
         }

        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
                             }
  
       return sout.toString();
 
      }  








public String general()
     {
       StringWriter sout = new StringWriter();
        PrintWriter out = new PrintWriter(sout);

        try {  
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:jitendra","scott", "tiger");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String total_hits="";
            String spider_hits="";
            String no_of_users="";
            String no_of_sessions="";
            ResultSet rs;
            String s="";
            s="select count(*) count from (select distinct * from log_information where url not like '%jpg' and url not like '%png' and url not like '%gif' and url not like '/robots.txt'  and url not like '%.GIF' and url not like '%.css' and url not like '%.js' and url not like '%.JPG' and url not like '%.PNG' and url not like '%favicon%') l";
            rs=stmt.executeQuery(s);
            while(rs.next())
            {
              total_hits=rs.getString("count");
            }
            
            s="select count(*) count from (select distinct * from log_information where user_agent like '%.com%') l";
            rs=stmt.executeQuery(s);
            while(rs.next())
            {
              spider_hits=rs.getString("count");
            }

            s="select count(*) count from users_path";
            rs=stmt.executeQuery(s);
            while(rs.next())
            {
              no_of_users=rs.getString("count");
            }

            s="select count(*) count from sessions";
            rs=stmt.executeQuery(s);
            while(rs.next())
            {
              no_of_sessions=rs.getString("count");
            }

            out.println("<html><body bgcolor=\"#ffffcc\"><table border=\"1\"><tr><th>category</th><th>hits</th></tr>");

            out.println("<tr><td>"+"total_hits"+"</td><td>"+total_hits+"</td></tr>");

            out.println("<tr><td>"+"spider_hits"+"</td><td>"+spider_hits+"</td></tr>");
      
            out.println("<tr><td>"+"cached_hits"+"</td><td>"+cached_hits+"</td></tr>");

            out.println("<tr><td>"+"no_of_users"+"</td><td>"+no_of_users+"</td></tr>");

            out.println("<tr><td>"+"no_of_sessions"+"</td><td>"+no_of_sessions+"</td></tr>");

            out.println("</table></body></html>");
               
            out.close();
            conn.close();
            
         }

        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
                             }
  
       return sout.toString();
 
      }  











public String status_report()
     {
       StringWriter sout = new StringWriter();
        PrintWriter out = new PrintWriter(sout);

        try {  
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:jitendra","scott", "tiger");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String s="";
            String not_found="";
            String service_unavailable="";
            String forbidden="";
            String internal_server_error="";
            s="select count(*) count from (select distinct * from log_information) where  status='404'";
            ResultSet rs=stmt.executeQuery(s);
            while(rs.next())
            {
               not_found=rs.getString("count");
            }
            
            s="select count(*) count from (select distinct * from log_information) where status='503'";
            rs=stmt.executeQuery(s);
            while(rs.next())
            {
               service_unavailable=rs.getString("count");
            }

            s="select count(*) count from (select distinct * from log_information) where status='403'";
             rs=stmt.executeQuery(s);
            while(rs.next())
            {
               forbidden=rs.getString("count");
            }

            s="select count(*) count from (select distinct * from log_information) where  status='500'";
            rs=stmt.executeQuery(s);
            while(rs.next())
            {
               internal_server_error=rs.getString("count");
            }




            out.println("<html><body bgcolor=\"#ffffcc\"><table border=\"1\"><tr><th>error</th><th>hits</th></tr>");

            out.println("<tr><td>"+"not_found"+"</td><td>"+not_found+"</td></tr>");

            out.println("<tr><td>"+"service_unavailable"+"</td><td>"+service_unavailable+"</td></tr>");
      
            out.println("<tr><td>"+"forbidden"+"</td><td>"+forbidden+"</td></tr>");

            out.println("<tr><td>"+"internal_server_error"+"</td><td>"+internal_server_error+"</td></tr>");

            
            out.println("</table></body></html>");
               
            out.close();
            conn.close();
            
            }

        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
                             }
  
       return sout.toString();
 
      }  







public String apriory()
{
 
 StringWriter sout = new StringWriter();
 PrintWriter out = new PrintWriter(sout);
 try {  
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:jitendra","scott", "tiger");
             Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

              Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
              Statement stmt3 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String s1;
            int x=1,y;
            float z;
            String ip2="";
            int cached_hits=0;
            String ip="119.235.54.242";
	    s1 = "select client_ip,version,user_agent from data_cleaning group by(client_ip,version,user_agent)";
            ResultSet rs1 = stmt1.executeQuery(s1);
             String st1="com";
             String st2="google";
             String st3="-";
             int i,j,k=0,count,m,p,g,s,n;
             Vector l1=new Vector();
            while (rs1.next()) 
            {   
               Vector a=new Vector();
                
               String temp="";
                String ip1 = rs1.getString("client_ip");
                String version1=rs1.getString("version");
                String user_agent1=rs1.getString("user_agent");
                ResultSet rs2 = stmt2.executeQuery("select * from data_cleaning where client_ip='"+ip1+"' and version='"+version1+"' and user_agent='"+user_agent1+"' order by time");
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
                 l1.add(a.get(i));
                }          
  
            } 


  String str=" ";
  Vector l2=new Vector();
  Vector temp1=(Vector)l1.get(0);
  Vector l=new Vector();
  l.add(temp1.get(0));
  for(i=0;i<l1.size();i++)
  {
    Vector temp=(Vector)l1.get(i);
    for(j=0;j<temp.size();j++)
    {
      if(!l.contains(temp.get(j)))
        l.add(temp.get(j));
     }
   }
   for(k=0;k<l.size();k++)
   {
     count=0;
     for(i=0;i<l1.size();i++)
     {
      Vector temp=(Vector)l1.get(i);
      if(temp.contains(l.get(k)))
      {
        count++;
      }
     }
     l2.add(count);
    }
   //System.out.println(l+"\n");
   Hashtable table=new Hashtable();
   Vector items=new Vector();
   Vector fre=new Vector();
   table.put("i",items);
   table.put("f",fre);
   Vector v_items=(Vector)table.get("i");
   Vector v_fre=(Vector)table.get("f");
   for(i=0;i<l.size();i++)
   {
     Vector v=new Vector();
     v.add(l.get(i));
     v_items.add(v);
     v_fre.addElement(l2.get(i));
   }
  
    //System.out.println("\n"+table.entrySet()+"\n");



   while(true)                                           //after removing less frequent item sets
   {
   p=0;
   for(i=0;i<v_fre.size();i++)
    {
     k=(Integer)v_fre.get(i);
     if(k<6)
     {
       v_fre.remove(i);
       v_items.remove(i);
       p=1;
     }
    }
   if(p==0)
   {
     break;
   }
  }
   //System.out.println("\n"+"after removing less frequent item sets "+table.entrySet()+"\n");   // above steps completed till L1



//below steps are from L1 


A a1=new A();
Vector vtable=new Vector();
vtable=v_items;
while(vtable.size()>1)
{
x++;
vtable=a1.join(vtable,x);
vtable=a1.freq_count(vtable,l1);
}
System.out.println("vtable is"+vtable+"\n");
System.out.println("total number of cached hits = "+cached_hits+"\n");




Vector v_fre1=new Vector();
for(i=0;i<vtable.size();i++)
{
 m=0;
 Vector v=new Vector();
 v=(Vector)vtable.get(i);
 for(j=0;j<l1.size();j++)
 {
  Vector v1=(Vector)l1.get(j);
  p=1;
  for(k=0;k<v.size();k++)
  {
    if(!v1.contains(v.get(k)))
    {
      p=0;
      break;
    }
  }
  if(p==1)
  {
   m++;
  }
 }
v_fre1.add(m);
}

System.out.println("v_fre1 is"+v_fre1+"\n");



 Vector v6=new Vector();
 Vector v7=new Vector();
 Vector v8=a1.only_subgroup(vtable);
 Vector v11=new Vector();
 Vector v12=new Vector();
Vector v13=new Vector();    // for main individ elements

for(j=0;j<vtable.size();j++)
{
 Vector v9=(Vector)v8.get(j);
 Vector v10=new Vector();

 
 for(k=0;k<v9.size();k++)           //add indi ele for first time
 {
  v10.add(v9.get(k));                 
 }



 v11=(Vector)v8.get(j);
 v6=a1.only_subgroup(v11);


 for(s=0;s<v6.size();s++)             //add indi ele for second time
 {
    v12=(Vector)v6.get(s);
   for(p=0;p<v12.size();p++)
   {
     v10.add((Vector)v12.get(p));             
   }
  }


 for(i=0;i<v6.size();i++)
  {
   Vector v=(Vector)v6.get(0);
   if(v.size()==2)
   {
     break;
   }
  
  v11=(Vector)v8.get(j); 
  v7=a1.only_subgroup(v11);
 

 
  for(s=0;s<v7.size();s++)                //add indi ele for third time
 {
    v12=(Vector)v7.get(s);
   for(p=0;p<v12.size();p++)
   {
     v10.add((Vector)v12.get(p));             
   }
  }


  }  // for(i)


v10=a1.remove_same_elements(v10);
v13.add(v10);


}  // for (j)

System.out.println("v13 is"+v13+"\n");


 /* Vector a=new Vector();
  
  a.add("i1");a.add("i2");a.add("i5");a.add("i6");
  Vector v5=new Vector();
  v5.add(a);
  v6=a1.only_subgroup2(v5);
  v6=a1.only_subgroup2((Vector)v6.get(0));
  for(i=0;i<v6.size();i++)
  {
   Vector v=(Vector)v6.get(0);
   if(v.size()==2)
   {
     break;
   }
   
  v5=a1.only_subgroup2((Vector)v6.get(i));
  }*/





// for frequency_count

Vector vfre1=new Vector();
Vector vfre2=new Vector();
for(i=0;i<v13.size();i++)
{
 vfre1=a1.frequency_count((Vector)v13.get(i),l1);
 vfre2.add(vfre1);
}
System.out.println("\n"+"vfre2 is"+vfre2+"\n");




Vector confidence1=new Vector();
for(i=0;i<vfre2.size();i++)
{
 Vector confidence2=new Vector();
 Vector v=(Vector)vfre2.get(i);
 for(j=0;j<v.size();j++)
 {
   
    x=(Integer)v_fre1.get(i);
    y=(Integer)v.get(j);
    z=((float) x/y)*100;
    confidence2.add(z);
  }
confidence1.add(confidence2);
}

System.out.println("\n"+"confidence is"+confidence1+"\n");
out.println("<html><body bgcolor=\"#ffffcc\">"+"frequent itemsets are"+vtable+"<br><br><br>"+"subsets are"+v13+"<br><br><br>"+"confidence values are"+confidence1+"</body></html>");
out.close();
conn.close();
}  //for try






catch(Exception e)
{
  
  e.printStackTrace();
}
return sout.toString();

 }  //for apriory













public static void main( String args[] )
	{
		// Create an instance of the test application
		SplitPane2 mainFrame = new SplitPane2();
                                     mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible( true );
	}
}


 






  class Chooser extends JFrame                                         //file chooser class
  {
      JFileChooser chooser;
      String fileName;
      public Chooser()
            {
              chooser = new JFileChooser();
              int r = chooser.showOpenDialog(new JFrame());
             if (r == JFileChooser.APPROVE_OPTION) 
                       {
                        fileName = chooser.getSelectedFile().getPath();
                       }
            }
   }







class A                                 //Class A
{
  int i,j,k,p,s,g,m;
  String str=new String(" ");
  Vector join(Vector vtable,int x)
  {
   Vector v_table=new Vector();
   for(i=0;i<vtable.size();i++)   //for Ck in apriory algorithm
   {
     for(j=i+1;j<vtable.size();j++)
     {
       Vector v1=new Vector();
       Vector v2=new Vector();
       v1=(Vector)vtable.get(i);
       Vector a1=new Vector();
       for(k=0;k<v1.size();k++)
       {
         a1.add(v1.get(k));
       }
       v2=(Vector)vtable.get(j);
       for(k=0;k<v2.size();k++)
       {
         if(!v1.contains(v2.get(k)))
         {
           
           a1.add(v2.get(k));
           //System.out.println(v2.get(k)+" "+"\n");
          }
       }
       v_table.add(a1);
       //System.out.println(a1+"\n");
     }
   } 



while(true)                       // for max no of elements in Ck list
{
p=0;
for(i=0;i<v_table.size();i++) 
{
 Vector v=new Vector();
 v=(Vector)v_table.get(i);
 if(v.size()>x)
 {
  v_table.remove(v);
  p=1;
 }
}
if(p==0)
{
 break;
}
}






while(true)                         // for equal members in Ck
{
p=0;
for(i=0;i<v_table.size();i++) 
{
 Vector v=(Vector)v_table.get(i);
 for(j=i+1;j<v_table.size();j++)
 {
  Vector v1=(Vector)v_table.get(j);
  if(v.equals(v1))
  {
   v_table.remove(j);
   p=1;
  }
 }
}
if(p==0)
{
 break;
}
}




while(true)                              // for equal members but different order in Ck
{
s=0;
for(i=0;i<v_table.size();i++) 
{
 Vector v=(Vector)v_table.get(i);
 for(j=i+1;j<v_table.size();j++)
 {
  p=1;
  Vector v1=(Vector)v_table.get(j);
  for(k=0;k<v1.size();k++)
  {
    if(!v.contains(v1.get(k)))
    {
       p=0;
    }
   }
  if(p==1)
  {
    v_table.remove(j);
    s=1;
  }
 }
}
if(s==0)
{
 break;
}
}

//System.out.println("v_table is"+v_table+"\n");


Vector v3=new Vector();                             // for subgroups in Ck
Vector v5=new Vector();
for(g=0;g<v_table.size();g++)
{
 Vector v2=new Vector();
 Vector v=(Vector)v_table.get(g);
 v5.add(v_table.get(g));
 if(v.size()==2)
 {
   for(i=0;i<v.size();i++)
   {
     Vector v1=new Vector();
     v1.add(v.get(i));
     v2.add(v1);
   }
   v3.add(v2);
  }
 else
 { 
 for(i=0;i<=1;i++)
 {
   
   for(j=i+1;j<=2;j++)
   {
     
     if(i==0 && (j==v.size()-1))
     {   }
     else
     {
     s=j;
     str="";
     while(s<v.size())
     {
         m=j;
         Vector v1=new Vector();
         v1.add(v.get(i));
         
         for(p=1;p<v.size()-1;p++)
         {
           //System.out.println(p+"\n");
           String t=(String)v.get(m);
           if(t.compareTo(str)!=0)
           {
             
             //System.out.println(str+" in if "+"\n");
             v1.add(v.get(m));
           }
           else
           {
             //System.out.println(str+" in else "+"\n");
             v1.add(v.get(++m));  
           }
           m++;
          //System.out.println(" m is "+m+"\n");
         }
         s=m;
         str=(String)v.get(m-1);
         v2.add(v1);
        // System.out.println("adding"+v1+"\n");
      }}
     }
   }
   v3.add(v2);
 }
}
//System.out.println("\n"+" subgroups "+v3+"\n");





                                        
for(i=0;i<v3.size();i++)                       //remove if subgroups in Ck are not there in Lk-1
{
 p=0;
 Vector v=(Vector)v3.get(i);
 for(j=0;j<v.size();j++)
 {
   Vector v1=(Vector)v.get(j);
   //System.out.println(v1+"\n");
   if(!vtable.contains(v1))
   { 
     
     p=1;
     //System.out.println(p+" "+v1+"\n");
     break;
   }
 }
 if(p==1)
 {
   v_table.remove(v5.get(i));
   
   //System.out.println("removing"+v5.get(i)+"\n");
  
 }
}


return v_table;

}  //join




Vector freq_count(Vector v_table,Vector l1)             // for frequency count and removal if less than threshold
{
 Vector v_fre1=new Vector();
for(i=0;i<v_table.size();i++)
{
 m=0;
 Vector v=new Vector();
 v=(Vector)v_table.get(i);
 for(j=0;j<l1.size();j++)
 {
  Vector v1=(Vector)l1.get(j);
  p=1;
  for(k=0;k<v.size();k++)
  {
    if(!v1.contains(v.get(k)))
    {
      p=0;
      break;
    }
  }
  if(p==1)
  {
   m++;
  }
 }
v_fre1.add(m);
}

//System.out.println("\n"+v_fre1+"\n");  


                     
while(true)                                           //in Ck remove for less freq
{
 s=0;
for(i=0;i<v_fre1.size();i++)
{
 j=(Integer)v_fre1.get(i);
 if(j<6)
 {
   //System.out.println("i="+i+" "+v_table.get(i)+" ");
   v_fre1.remove(i);
   v_table.remove(i);
   s=1;
 }
}
if(s==0)
 break;
}

return v_table;

}//for frequency count












Vector only_subgroup(Vector vtable)                  // for only_subgroup
{
Vector v3=new Vector();                             
for(g=0;g<vtable.size();g++)
{
 Vector v2=new Vector();
 Vector v=(Vector)vtable.get(g);

 if(v.size()==2)
 {
   for(i=0;i<v.size();i++)
   {
     Vector v1=new Vector();
     v1.add(v.get(i));
     v2.add(v1);
   }
   v3.add(v2);
  }
 else
 { 
 for(i=0;i<=1;i++)
 {
   
   for(j=i+1;j<=2;j++)
   {
     
     if(i==0 && (j==v.size()-1))
     {   }
     else
     {
     s=j;
     str="";
     while(s<v.size())
     {
         m=j;
         Vector v1=new Vector();
         v1.add(v.get(i));
         
         for(p=1;p<v.size()-1;p++)
         {
           //System.out.println(p+"\n");
           String t=(String)v.get(m);
           if(t.compareTo(str)!=0)
           {
             
             //System.out.println(str+" in if "+"\n");
             v1.add(v.get(m));
           }
           else
           {
             //System.out.println(str+" in else "+"\n");
             v1.add(v.get(++m));  
           }
           m++;
          //System.out.println(" m is "+m+"\n");
         }
         s=m;
         str=(String)v.get(m-1);
         v2.add(v1);
        // System.out.println("adding"+v1+"\n");
      }}
     }
   }
   v3.add(v2);
 }
}
System.out.println("\n"+" subgroups "+v3+"\n");
return v3;
}//for only_subgroup







Vector remove_same_elements(Vector v10)
{
   for(i=0;i<v10.size();i++)
  {
    for(j=i+1;j<v10.size();j++)
    {
      if(v10.get(i).equals(v10.get(j)))
      {
         v10.remove(j);
         j--;
       }
     }
   }
 return v10;
}





//for frequency count

Vector frequency_count(Vector v_table,Vector l1)
{
 Vector v_fre1=new Vector();
for(i=0;i<v_table.size();i++)
{
 m=0;
 Vector v=new Vector();
 v=(Vector)v_table.get(i);
 for(j=0;j<l1.size();j++)
 {
  Vector v1=(Vector)l1.get(j);
  p=1;
  for(k=0;k<v.size();k++)
  {
    if(!v1.contains(v.get(k)))
    {
      p=0;
      break;
    }
  }
  if(p==1)
  {
   m++;
  }
 }
v_fre1.add(m);
}
return v_fre1;
}










} //class a

