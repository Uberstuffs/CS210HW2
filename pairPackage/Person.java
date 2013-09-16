//Person.java
package pairPackage;
import java.util.*;
import java.io.*;

public class Person
{
    String  name = null;
    int     age  = 0;
    char    gender = ' ';
    String  title = null;
    //String major in subclass

    String tmpStr;
    String MrSmith = "Agent Smith,999,M,Mr. Smith";

    public Person( String aStr )
    {
        findName(   aStr );
        findAge(    aStr );
        findGend(   aStr );
        findTitle(  aStr );
    }

    public void printName()
    {
        System.out.print(name);
    }

    public String parseComma( String ini, int c  )
    {
        tmpStr = "";
        for(int i = 0; c >= 0 && i < ini.length(); i++)
        {
            if(c == 0 && ini.charAt(i) != ',')
                tmpStr += ini.charAt(i);
            if(ini.charAt(i) == ',')
                c--;
        }
        return tmpStr;
    }

    public void findName( String ini )
    {
        name = parseComma( ini, 0 );
    }

    public void findAge( String ini )
    {
        tmpStr = parseComma( ini, 1 );
        age = Integer.valueOf( tmpStr );   
    }

    public void findGend( String ini )
    {
        
        tmpStr = parseComma( ini, 2 );
        gender = tmpStr.charAt(0);
    }
    
    public void findTitle( String ini )
    {
        title = parseComma( ini, 3 );    
    } 
}
