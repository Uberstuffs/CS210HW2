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
        
        pairem();
        oneofeach();
    }
    
    public static void oneofeach()
    {
        Person tmpP;
        List<Person> pl1 = new ArrayList<Person>();
        List<Person> pl2 = new ArrayList<Person>();
        List<Person> pl3 = new ArrayList<Person>();
        List<Person> pl4 = new ArrayList<Person>();

        String CS = "Computer Science";
        String CE = "Computer Engineering";
        String EE = "Electrical Engineering";
        String AC = "Accounting";

        randomize();

        for(int i = 0; i < peopleList.size(); i++)
        {
            tmpP = peopleList.get(i);

            if(tmpP.findMajor() == CS)
                pl1.add(tmpP);
            else if(tmpP.findMajor() == CE)
                pl2.add(tmpP);
            else if(tmpP.findMajor() == EE)
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
    
        int longest1 = longestName(pl1) + 2;
        int longest2 = longestName(pl2) + 2;
        int longest3 = longestName(pl3) + 2;
        int longest4 = longestName(pl4) + 2;
        int ext1 = 0, ext2 = 0, ext3 = 0, ext4 = 0;
        String ex1 = "", ex2 = "", ex3 = "", ex4 = "";

        if(CS.length() < longest1)
            ext1 = longest1 - CS.length();
                       
        if(CE.length() < longest2)
            ext2 = longest2 - CE.length();
        
        if(EE.length() < longest3) 
            ext3 = longest3 - EE.length();

        if(AC.length() < longest4)
            ext4 = longest4 - AC.length();

        for(int i = 0; i < ext1; i++)
            ex1 += " ";
        
        for(int i = 0; i < ext2; i++)
            ex2 += " ";
        
        for(int i = 0; i < ext3; i++)
            ex3 += " ";
            
        for(int i = 0; i < ext4; i++)
            ex4 += " ";

        Person p1, p2, p3, p4;
        System.out.println(CS + "  " + ex1 + CE + "  " + ex2 + EE + "  " + ex3 + AC + ex4);         
        for(int i = 0; i < shortest; i++)
        {
            p1 = pl1.get(i);
            p2 = pl2.get(i);
            p3 = pl3.get(i);
            p4 = pl4.get(i);
            System.out.println( p1 + ex1 + p2 + ex2 + p3 + ex3 + p4 + ex4);
        }
    } 

    public static int longestName(List<Person> l)
    {
        int length = 0;
        for(int i = 0; i < l.size(); i++)
        {
            if(l.get(i).name().length() > length)
                length = l.get(i).name().length();
        }
        return length;
    } 
}
