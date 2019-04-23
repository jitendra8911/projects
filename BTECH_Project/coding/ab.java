import java.util.*;
import java.io.*;
class ab
{
 public static void main(String args[])
 {
  int i,j;
  Vector v1=new Vector();
 
  v1.add("a");v1.add("a");v1.add("b");v1.add("c");v1.add("c");v1.add("d");v1.add("b");
  for(i=0;i<v1.size();i++)
  {
    for(j=i+1;j<v1.size();j++)
    {
      if(v1.get(i).equals(v1.get(j)))
      {
         v1.remove(j);
         j--;
       }
     }
   }
 System.out.println(v1);
  }
}