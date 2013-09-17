//Faculty.java
package pairPackage;
import java.util.*;
import java.io.*;

class Instructors extends People
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
                    populate(new Faculty(str));
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

        System.out.println("Before rosters");
        deptRosters();
    }

    public static void deptRosters()
    {
        // Create a list for each major
        List<Faculty> fl1 = new ArrayList<Faculty>();
        List<Faculty> fl2 = new ArrayList<Faculty>();
        List<Faculty> fl3 = new ArrayList<Faculty>();

        String AC = "Accounting";
        String CS = "Computer Science";
        String ECE = "Electrical and Computer Engineering";         
        
        // Take every node from peoplelist and put it into a Faculty list
        // based on the department field.
        Faculty tmpP;
        for(int i = 0; i < peopleList.size(); i++)
        {
            tmpP = (Faculty)peopleList.get(i);
            if(tmpP.dept().equals(AC))
                fl1.add(tmpP);
            if(tmpP.dept().equals(CS))
                fl2.add(tmpP);
            if(tmpP.dept().equals(ECE))
                fl3.add(tmpP);
        } 

        sortFacultyList(fl1);
        sortFacultyList(fl2);
        sortFacultyList(fl3);

        printFacultyList(fl1);
        printFacultyList(fl2);
        printFacultyList(fl3); 
    }

    //Sorting list function thanks to util folder & java tutorials
    public static void sortFacultyList(List<Faculty> l)
    {
        Collections.sort(l, new Comparator<Faculty>()
        {
            public int compare(Faculty a, Faculty b)
            {
                return (a.name.compareTo(b.name()));
            }
        });
    }

    public static void printFacultyList(List<Faculty> l)
    {
        if(l.size() == 0)
            return;
        System.out.println(l.get(1).dept() + "\n");
        for(int i = 0; i < l.size(); i++)
            System.out.println(l.get(i).name());
        System.out.print("\n");
    }
}
