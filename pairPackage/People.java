// People.java
package pairPackage;
import java.util.*;
import java.io.*;

public class People
{
    static List<Person> peopleList = new ArrayList<Person>();

    public static void populate(Person p) throws FileNotFoundException, IOException
    {  
        peopleList.add(p); 
    }
    
    public void pairem()
    {
        
    }
}
