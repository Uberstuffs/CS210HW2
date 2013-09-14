import java.util.*;
import java.io.*;

public class pairem2
{
    public static void main(String  args[]) throws FileNotFoundException, IOException
    {
        //ask user for file type of students or facalty        
    }

    public class Person
    {
        String  name;
        int     age;
        char    gender;
        String  Title;

        public void initialize()
        {
            
        }
    }
   
    class Student extends Person
    {

    }

    class Faculty extends Person
    {

    }
 
    public class People
    {
        List<Person> peopleList;
            
        public void populate()
        {
            //reads data into peopleList from file using Person objects 
            //if( chartemp == ',' ) change from one field to the next 
        }

        public void pairem()
        {
            //pair the data in peopleList;
        }
    }
    
    class Students extends People
    {
        
    }

    class Instructors extends People
    {

    }
}
