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
   
    public static void pairem()
    {
        randomize();

        System.out.print("Pair Assignments ( " + (peopleList.size() / 2) + " pairs ) "); 
        if((peopleList.size() % 2) != 0)
        {
            print(peopleList.size() - 1);
            System.out.print(" is an extra.");
        }
        System.out.print("\n");       
 
        for(int i = 0; i < peopleList.size() - 1; i += 2)
        {
            print(i);
            System.out.print("\t\t");
            print(i + 1);
            System.out.print("\n");
        }
    }
 
    public static void randomize()
    {
        Random rand = new Random();
        for(int i = 0; i < peopleList.size(); i++)
        {
            int index = rand.nextInt(i + 1);
            
            Person temp = peopleList.get(index);
            peopleList.set(index, peopleList.get(i));
            peopleList.set(i, temp);
        }        
    }

    public static void print(int i)
    {
        Person tmpPerson = peopleList.get(i);
        tmpPerson.printName();
    }
}
