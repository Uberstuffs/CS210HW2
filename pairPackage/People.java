package pairPackage;
import java.util.*;
import java.io.*;

public class People
{
    List<Person> peopleList;

    public void populate( String stringname )
    {
        Person tmpPer;
        tmpPer.initialize();
        tmpPer.createPerson( stringname );
        peopleList.add( tmpPer );
    }
    
    public void pairem()
    {
        
    }
}
