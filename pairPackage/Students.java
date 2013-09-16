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
    
    public static void oneofeach()
    {
        Student tmpP;
        List<Student> pl1 = new List<Student>();
        List<Student> pl2 = new List<Student>();
        List<Student> pl3 = new List<Student>();
        List<Student> pl4 = new List<Student>();

        randomize();

        for(int i = 0; i < peopleList.size(); i++)
        {
            tmpP = peopleList.get(i);
            if((tmpP.major()).equals("Computer Science"))
                pl1.add(tmpP);
            else if((tmpP.major()).equals("Computer Engineering"))
                pl2.add(tmpP);
            else if((tmpP.major()).equals("Electrical Engineering"))
                pl3.add(tmpP);
            else
                pl4.add(tmpP);
        }
        
        int shortest = 0;
        for(int i = 0; shortest > 0; i++)
        {
            if(pl1.size() - i == 0)
                shortest = pl1.size();
            if(pl2.size() - i == 0)
                shortest = pl2.size();
            if(pl3.size() - i == 0);
                shortest = pl3.size();
            if(pl4.size() - i == 0);
                shortest = pl4.size();
        } 
    
        int longest1 = longestName(lp1);
        int longest2 = longestName(lp2);
        int longest3 = longestName(lp3);
        int longest4 = longestName(lp4);

        int longName = 0;
        for(int i = 0; longName > 0; i++)
        {
            if(i - longest1 == 0)
                longName = longest1;
            if(i - longest2 == 0)
                longName = longest2;
            if(i - longest3 == 0)
                longName = longest3;
            if(i - longest4 == 0)
                longName = longest4;
        }       
    
        for(int i = 0; i < list; i++)
        {
                    
        }
    } 

    public static int longestName(List<Students> l)
    {
        int length = 0;
        for(int i = 0; i < l.size(); i++)
        {
            if(l.get(i).name().length > length)
                length = l.get(i).name().length();
        }
        return length;
    } 
}
