/**
 * Zack Yama
 * CS 210
 * Homework 1
 * 9/10/2013
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class pairem
{
	public static void main(String[] args) throws IOException, FileNotFoundException
	{

		// Declare Variables
		String person;
		List<String> listOfPeople = new ArrayList<String>();
		// Array of strings declared after num members found	

		
		//Check to see ifd a filename was given at run time,
		//if it wasn't then take cmd line input.		
		try
		{
			if( args.length == 0 )
			{				
				BufferedReader input = new BufferedReader( new InputStreamReader(args[0]) );
			}
			else
			{
				BufferedReader input = new BufferedReader( new FileReader( args[0] ));
			}

			while((person = input.readLine()) != null )
			{
				listOfPeople.add( person );
			}
			input.close();
			
		catch( FileNotFoundException error )
		{
			System.out.println( "Usage: pairem [filename] " );
			System.exit(0);
		}
	
		catch( IOException error )
		{
			System.exit(0); 
		}
	
		// Create the array and read data into it
		String[] people = new String[ listOfPeople.size() ];		
		listOfPeople.toArray( people );
		
		// Randomize array
		randomizeArray( people );

		// Check for an odd number of people
		if( ( listOfPeople.size() % 2 ) == 0 )
		{
			System.out.println( "Pair Assignments ( " + (listOfPeople.size() / 2) + " pairs )\n" );
		}
		
		else
		{
			person = people[ listOfPeople.size() - 1 ];
			System.out.println( "Pair Assignment ( " + ((listOfPeople.size() - 1) / 2) + " pairs: " + person + " is an extra. )\n" );
		}
	
		// Output pairs to user. For an odd size array, the pairs are still
		// printed correctly because the loop only prints the even indicies. 
		for( int i = 0; i < listOfPeople.size() - 1; i += 2 )
		{
			System.out.println( people[i] + "\t\t" + people[ i + 1 ] );
		}
	}
	

	// Randomizes the array
	static void randomizeArray( String[] array )
	{
		Random rand = new Random();
		for( int i = 0; i < array.length; i++ )
		{
			int index = rand.nextInt(i + 1);
			
			//Swap a "random" index with i's index
			String temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}
}
