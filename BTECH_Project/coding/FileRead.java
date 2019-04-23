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
  
class FileRead {  
    public static void main(String args[]) {  
        try {  
            
            String str=new String();
            String str1=new String();
            ArrayList storeWordList = new ArrayList();  
            File file = new File("welcome.txt");
        
            BufferedReader br = new BufferedReader(new FileReader(file));  
            String strLine;  
            //Read File Line By Line  
            while ((strLine = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(strLine, " ");
                while(st.hasMoreTokens())
                storeWordList.add(st.nextToken());  
                  
            }  
            //Close the input stream  
            
  
             str1="hi";
             
            for (Iterator iter = storeWordList.iterator(); iter.hasNext();) {  
              
               str=(String)iter.next();
                if(str.equals(str1))
                System.out.println(str);  
            }  
  
             
  
        } catch (Exception e) {//Catch exception if any  
            System.err.println("Error: " + e.getMessage());  
        }  
    }  
}  