import java.util.*;
import java.io.*;

public class pairem2
{
    public static void main(String  args[]) throws FileNotFoundException, IOException
    {
        //ask user for file type of students or facalty 
        //class main()s open the file and read data from it
        if( args.length == 0 )
        {   
            System.out.println("Usage: pairem [filename]");
            System.exit(-1);
        }       
    }

    public class Person
    {
        String  name;
        int     age;
        char    gender;
        String  title;
        //String major; found in subclass Student    

        public void initialize(String n, int a, char g, String t)
        {
            // parse line of text based on ","
            name =      n;   //first block
            age =       a;    //second block
            gender =    g;  //3rd
            title =     t;  //4th
        }
    }
   

// Initialize major/department with 5th field from file
// Can be CS, EE, CE, or Accounting
//-----
    class Student extends Person
    {
        String major;
    }

    class Faculty extends Person
    {
        String department;
    }
//------
 
    public class People
    {
        List<Person> peopleList;
            
        public void populate( stringname )
        {
            //parse string
            String n, t;
            int a;
            char g;
            Person tmpPer; 
            tmpPer.initialize( n, a, g, t );
            peopleList.Add( tmpPer );
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
        public void oneofeach()
        {
            //pair students in grps of 4 with different majors
            //list those not paired in a group of 4
            //each column must be 2 spaces wider than longest member
        }

        public void main(String args[]) throws IOException, FileNotFoundException
        {
            //take argv filename and perform "Students" methods on it
            Person tmpPers;
            BufferedReader stud = new BufferedReader( new FileReader(args[0]));
           
            //tmpPers.initialize( ) 
            //peopleList.add( tmpPers );

 
            stud.close();
        }
    }

    class Instructors extends People
    {
        public void deptrosters()
        {
            //alphebetically print department titles and then alphebetically
            //print names contained therein
        }
        
        public void main(String args[])
        {
            //tage argv filename and perform "Facalty" methods on it
            BufferedReader fac = new BufferedReader( new FileReader(args[0]));        

            fac.close();
        }
    }
}
