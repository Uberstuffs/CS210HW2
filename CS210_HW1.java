/**
 * CS210 Homework 1 Program generates a list of partners from an input file.
 *
 * @author Gabe Pearhill
 */
import java.io.BufferedReader;
import java.util.Date;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class CS210_HW1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {        
            CS210_HW1 names = new CS210_HW1();
            //Read names from file
            List<String> nameList;
            if(args.length > 0)
            {
                nameList = names.readFile(args[0]);
            }
            else
            {
                nameList = names.readInput();
            }
            List<String> partnerList = new LinkedList<>();
            Date date = new Date(); //Use date object to get time in milliseconds
            //to seed the random number generator
            Random random = new Random(date.getTime()); //Random object for partner
            //selection
            String pairedNames; //String to store paired names
            int partner1 = 0, partner2 = 0; //Variable to store generated parter's index

            while (nameList.size() >= 2) {
                partner1 = random.nextInt(nameList.size());
                partner2 = random.nextInt(nameList.size());
                if (partner1 != partner2) {
                    pairedNames = nameList.get(partner1) + "\t" + nameList.get(partner2);
                    partnerList.add(pairedNames);
                    if (partner1 < partner2) {
                        nameList.remove(partner1);
                        nameList.remove(partner2 - 1);
                    } else if (partner1 > partner2) {
                        nameList.remove(partner1);
                        nameList.remove(partner2);
                    }
                }
            }
            System.out.println("Partners ( " + partnerList.size() + " pairs ): ");
            for (int i = 0; i < partnerList.size(); i++) {
                System.out.println("\t" + partnerList.get(i));
            }
            System.out.println("Unpaired: ");
            for (int i = 0; i < nameList.size(); i++) {
                System.out.println("\t" + nameList.get(i));
            }
    }

    List<String> readFile(String fileName) throws FileNotFoundException, IOException {
        //Open file
        BufferedReader in = new BufferedReader(new FileReader(fileName));

        //Create containers
        String str;
        List<String> names = new LinkedList<>();

        //Get names in file
        while ((str = in.readLine()) != null) {
            names.add(str);
        }

        //Return names
        return names;
    }
    
    List<String> readInput() throws FileNotFoundException, IOException {
        //Open file
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //Create containers
        String str;
        List<String> names = new LinkedList<>();

        //Get names in file
        while ((str = in.readLine()) != null) {
            names.add(str);
        }

        //Return names
        return names;
    }
}
