//imports will probably be necisarry

public class Person{
    String name;
    int age;
    char gender;
    String title;
    
    //What does he mean initialize the person with a "string of command seperated fields" ?
        //it's actually "comma seperated fields". We initialize it using a line taken from a
        //file, and parse it based on commas. Each part then becomes it's corresponding piece 
        //of data. i.e. "James Hamond,28,male,The Top Gear Guy" will be divided into it's 
        //respective parts. 
    void CreatePerson(String n, int a, char g, String t)
    {
        name = n;
        age = a;
        gender = g;
        title = t;
    }
}

