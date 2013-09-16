//Student.java
package pairPackage;
import java.util.*;
import java.io.*;

public class Student extends Person
{
    String major;
    
    public Student(String s)
    {
        super(s);
        major = parseComma(s, 4);
    }  
}

