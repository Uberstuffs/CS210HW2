package pairPackage;
import java.util.*;
import java.io.*;

class Students extends People
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        if(args.length > 0)
        {
            try
            {
                BufferedReader in = new BufferedReader(new FileReader(args[0]));
                String str;
                while((str = in.readLine()) != null ) 
                {
                    populate(new Student(str));                    
                }  
            }
            catch(FileNotFoundException e)
            {
                System.out.println("Usage: Pairem [filename]");
                System.exit(-1);
            }
        }
        else
        {
            System.out.println("File not given");
        }
        
        pairem();
    }  
}
