package pairPackage;
import java.util.*;
import java.io.*;

public class Faculty extends Person
{
    String department;

    public Faculty(String s)
    {
        super(s);
        department = parseComma(s, 4);
    }
}
