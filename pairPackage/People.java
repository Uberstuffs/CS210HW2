// People.java
package pairPackage;
import java.util.*;
import java.io.*;

public class People
{
    List<Person> peopleList;
    
    public static void populate(String filename, Person p ) throws FileNotFoundException, IOException
    {  
        try
        {
            BufferedReader infile = new BufferedReader(new FileReader(filename));
            String str;
            while((str = infile.readLine()) != null)
            {
                p.init(str);
                peopleList.add(p); 
            }
        }
        catch(FileNotFoundException er)
        {
            System.out.println("Usage: pairem [filename]");
            System.exit(-1);      
        }        
        catch(IOException er)
        {
            System.out.println("IOException error");
            System.exit(-1);
        }
    }
    
    public void pairem()
    {
        
    }
}
