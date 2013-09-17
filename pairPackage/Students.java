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
            System.exit(-1);
        }
        
        //pairem(); works fine
        oneofeach();
    }
    
    public static void oneofeach()
    {
        // Create a list for each major  
        List<Student> pl1 = new ArrayList<Student>();
        List<Student> pl2 = new ArrayList<Student>();
        List<Student> pl3 = new ArrayList<Student>();
        List<Student> pl4 = new ArrayList<Student>();

        String CS = "Computer Science";
        String CE = "Computer Engineering";
        String EE = "Electrical Engineering";
        String AC = "Accounting";

        // Randomizes the original list of people
        randomize();

        // Take every node from peoplelist and put it into a Student list
        // based on the major field
        Student tmpP;
        for(int i = 0; i < peopleList.size(); i++)
        {
            tmpP = (Student)peopleList.get(i);
            if(tmpP.major().equals(CS))
                pl1.add(tmpP);
            if(tmpP.major().equals(CE))
                pl2.add(tmpP);
            if(tmpP.major().equals(EE))
                pl3.add(tmpP);
            if(tmpP.major().equals(AC))
                pl4.add(tmpP);
        }

//        System.out.println(pl1.get(0).name());
        
        // Find the shortest list
        int shortest = findShortestList(pl1, pl2, pl3, pl4);
        System.out.println(shortest);
        // Find the longest name including extra whitespace
        String longest1 = longestName(pl1) + 2;
        String longest2 = longestName(pl2) + 2;
        String longest3 = longestName(pl3) + 2;
        String longest4 = longestName(pl4) + 2;
       
        // Check to see if the major title is larger than the 
        // longest name. If so, make the major the longest name. 
        if(longest1.length() < CS.length())
            longest1 = CS + 2;
        if(longest2.length() < CE.length())
            longest2 = CE + 2;
        if(longest3.length() < EE.length())
            longest3 = EE + 2;
        if(longest4.length() < AC.length())
            longest4 = AC + 2;
        

        // Print out the four majors 
        System.out.print("\n");
        System.out.print(CS);
        spaceOut(CS, longest1);
        
        System.out.print(CE);
        spaceOut(CE, longest2);
        
        System.out.print(EE);
        spaceOut(EE, longest3);
        
        System.out.print(AC);
        spaceOut(AC, longest4);
        
        System.out.print("\n");
        
        // Print out the Students for each major
        String p1, p2, p3, p4;
        for(int i = 0; i < shortest; i++)
        {
            p1 = pl1.get(i).name();
            p2 = pl2.get(i).name();
            p3 = pl3.get(i).name();
            p4 = pl4.get(i).name();

            System.out.print(p1);
            spaceOut(p1, longest1);

            System.out.print(p2);
            spaceOut(p2, longest2);
            
            System.out.print(p3);
            spaceOut(p3, longest3);
         
            System.out.print(p4);
            spaceOut(p4, longest4);
            
            System.out.print("\n");
        }

        // Print out the remaining unpaired majors
        if(peopleList.size() % 4 != 0) //At least 1 person is unpaired
        {
            System.out.println("\nPeople who were unpaired: \n");   
        
            //loop for as long as if everyone was one major
            for(int i = shortest; i <= peopleList.size(); i++) 
            {
                if(pl1.size() > i)
                    System.out.println(pl1.get(i).name());
                if(pl2.size() > i)
                    System.out.println(pl2.get(i).name());
                if(pl3.size() > i) 
                    System.out.println(pl3.get(i).name());
                if(pl4.size() > i)
                    System.out.println(pl4.get(i).name());
            }
        } 
    }

    public static int findShortestList(List<Student> pl1, List<Student> pl2, List<Student> pl3, List<Student> pl4)
    {
        int shortest = 0;
        for(int i = 0; shortest == 0; i++)
        {
            if(pl1.size() - i == 0)
                shortest = pl1.size();
            if(pl2.size() - i == 0)
                shortest = pl2.size();
            if(pl3.size() - i == 0)
                shortest = pl3.size();
            if(pl4.size() - i == 0)
                shortest = pl4.size();
        }
        return shortest;
    }
   
    //Using a given length(longest), find out how much space
    //is needed to properly space out the columns in oneofeach() 
    public static void spaceOut(String aName, String longestName)
    {
        int space = aName.length();
        while(space <= longestName.length())
        {
            System.out.print(" ");
            space++;
        }
    } 

    public static String longestName(List<Student> l)
    {
        Person p;
        String s, longest = "";
        for(int i = 0; i < l.size(); i++)
        {
            p = l.get(i);
            s = p.name();
            if(s.length() > longest.length())
            {
                longest = s;
            }
        }
        return longest;
    } 
}
