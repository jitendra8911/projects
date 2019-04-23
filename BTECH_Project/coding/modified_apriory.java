//package Vector;  
  
import java.lang.*;
import java.io.*;
import java.util.*; 
import java.sql.*;
import oracle.jdbc.driver.*;
import oracle.sql.*;
import java.lang.Object.*;

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





















class modified_apriory {  
    public static void main(String args[]) {  
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
	    s1 = "select client_ip,version,user_agent from log_table1 group by(client_ip,version,user_agent)";
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





}  //for try






catch(Exception e)
{
  
  e.printStackTrace();
}
 }  //for main
}   //for sid_apr