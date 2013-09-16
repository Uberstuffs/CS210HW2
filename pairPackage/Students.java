package pairPackage;
import java.util.*;
import java.io.*;

class Students extends People
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        System.out.println( "Students Class" );
        
        if(args.length > 0)
        {
            populate(args[0], new Student());
        }
        else
        {
            System.out.println("File not given");
        }
    }   
}
