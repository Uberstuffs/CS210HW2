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
        Student tmpP;
        List<Student> pl1 = new ArrayList<Student>();
        List<Student> pl2 = new ArrayList<Student>();
        List<Student> pl3 = new ArrayList<Student>();
        List<Student> pl4 = new ArrayList<Student>();

        String CS = "Computer Science";
        String CE = "Computer Engineering";
        String EE = "Electrical Engineering";
        String AC = "Accounting";

        randomize();

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

        System.out.println(pl1.get(0).name());
        
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


        String p1, p2, p3, p4;
        System.out.print(CS);
        spaceOut(CS.length(), longest1);
        System.out.print(CE);
        spaceOut(CE.length(), longest2);
        System.out.print(EE);
        spaceOut(EE.length(), longest3);
        System.out.print(AC);
        spaceOut(AC.length(), longest4);
        System.out.print("\n");
 
        for(int i = 0; i < 1; i++)
        {
            p1 = pl1.get(i).name();
            p2 = pl2.get(i).name();
            p3 = pl3.get(i).name();
            p4 = pl4.get(i).name();
            System.out.print(p1);
            spaceOut(CS.length(), p1.length());
            System.out.print(p2);
            spaceOut(CE.length(), p2.length());
            System.out.print(p3);
            spaceOut(EE.length(), p3.length());
            System.out.print(p4);
            spaceOut(AC.length(), p4.length());
        } 
    }

    public static void spaceOut(int size, int space)
    {
        while(size < space)
        {
            System.out.print(" ");
            size++;
        }
    } 

    public static int longestName(List<Student> l)
    {
        int length = 0;
        Person p;
        String s;
        for(int i = 0; i < l.size(); i++)
        {
            p = l.get(i);
            s = p.name();
            if(s.length() > length)
            {
                length = s.length();
            }
        }
        return length;
    } 
}
