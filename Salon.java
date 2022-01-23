import java.util.*;

//Name of the program: Public Class Salon
//Author Name: Raiyan Hossain
//The algorithm is as the prompt states. It asks for user information for the client which then puts it into the stylists array for each one that is already in the system. 
//From there the user (client) is asked if they want to put their information in all of the stylists array or just the ones that they want for their appointment. 

//Doesn't specify if there is one or multiple clients per day - I wrote an array for one client per day 
//This program will help salon keep track of their stylists' appointments through creating an array for both clients
//and stylists, that asks user for client information, puts it in stylist schedule as well as asking the user
//for a specified stylist (if they choose to have one) and then displaying the list of available stylists

//Names of variables for Client are as listed: cfname (client first name) clname (client last name)
//time (time of appointment), cost (cost of appointment), date (date of appointment), service (type of appointment)
//For each name of variable, I listed examples and ways that each should be written
//first and last name are self-explanatory. As for everything else I listed it within the execution statement what should be written
//As for declarations of each variables, I listed the appropriate data types which are either String or double. 
//The first and last name, time, date and service are all strings bc those are up to the discretion of the client
//The cost is obviously a double as it alludes to a decimal number
//I used numerous methods, objects and helper methods to organize my code and instruct effective problem solving
//However I go over each method/object/helper method in my documentation part of the assignment - MS Word Document

public class Salon
{
	public static class Client
	{
		String cfname;
		String clname;
		String time;
		Double cost;
		String date;
		String service; //might have to turn into an array
		
		void Request()
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Client's first name: ");
			cfname = scan.nextLine();
			System.out.println("Client's last name: ");
			clname = scan.nextLine();
			System.out.println("Client's appointment time (Write as analog time i.e. 10:30 am/pm): ");
			time = scan.nextLine();
			System.out.println("Client's appointment date (Write as mm/dd/year): ");
			date = scan.nextLine();
			System.out.println("Client's service (haircut, blowout, hair dying, highlights, extensions, etc.): ");
			service = scan.nextLine();
			System.out.println("Client's cost (Write as double number i.e. 10.50): ");
			cost = scan.nextDouble();
				
			//scan.close();
			
		}
	}
	
	public static class Stylist
	{
		String sfname;
		String slname;
		Client[] schedule = new Client[31]; //Used 31 to represent number of days in a month 
		
		//put client data into stylists array
		//do in new helper method
		
		void Sinformation()
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the Stylists first name: ");
			sfname = scan.nextLine();
			System.out.println("Enter the Stylists last name: ");
			slname = scan.nextLine();
			//scan.close();
		}
	}
	
	public static void insertIntoSchedule(Client person, Stylist s)
	{
		//loop to check stylist schedule array
		for(int i = 0; i < s.schedule.length; i++)
		{
			//populate null value with client object
			if(s.schedule[i] == null)
			{
				s.schedule[i] = person;
			}
			else
				System.out.println("Already booked with clients");
		}
	}
	
	public static void fillStylistArr(Stylist[] arrStylists)
	{
		Stylist jim = new Stylist();
		jim.sfname = "Jim";
		jim.slname = "Halpert";
	
		Stylist pam = new Stylist();
		pam.sfname = "Pam";
		pam.slname = "Beasly";
		
		FillArray(arrStylists, jim);
		FillArray(arrStylists, pam);
	}
	
	public static Stylist[] FillArray(Stylist[] arrStylists, Stylist object)
	{
		for(int i = 0; i < arrStylists.length; i++)
		{
			if(arrStylists[i] == null)
			{
				arrStylists[i] = object;
				return arrStylists;
			}			
		}
		//arrStylists.add(object);
		//Implication is that the array is full, therefore it breaks
		System.out.println("Max Number of Stylists");
		return arrStylists;
	}
	
	public static Stylist retrieveFromName(Stylist[] arrStylists, Stylist object)
	{
		for(int i = 0; i < arrStylists.length; i++)
		{
			//Matches the name
			if(arrStylists[i] != null && object.sfname.equals(arrStylists[i].sfname) && object.slname.equals(arrStylists[i].slname))
			{
				return arrStylists[i];
			}
		}
		System.out.println("Could not find specified stylist");
		return object;
	}
	
	public static void getStylistName(Stylist[] arrStylists)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Available stylists: ");
		for(int i = 0; i < arrStylists.length; i++)
		{
			if(arrStylists[i] != null)
				System.out.println(arrStylists[i].sfname + " " + arrStylists[i].slname);
		}
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Stylist[] arrStylists = new Stylist[10]; //10 represents max number of stylists available
		
		Client temp = new Client();
		temp.Request();
		System.out.println(temp.cfname + " " + temp.clname);
		
		fillStylistArr(arrStylists);
		getStylistName(arrStylists);
		
		System.out.println("Do you want to print data for existing Stylists?(Yes/No): ");
		String answer = scan.nextLine();
		if(answer.equals("Yes"))
		{
			System.out.println("Please print first name of Stylist");
			String firstName = scan.nextLine();
			System.out.println("Please print last name of Stylist");
			String lastN = scan.nextLine();
			Stylist names = new Stylist();
			names.sfname = firstName;
			names.slname = lastN;
			//retrieveFromName(arrStylists, names);
			//System.out.println(retrieveFromName(arrStylists, names).sfname);
			System.out.println("Inserted Client into Schedule");
			insertIntoSchedule(temp, retrieveFromName(arrStylists, names));
		}
		else if(answer.equals("No"))
		{
			System.out.println("Please print first name of Stylist");
			String firstName = scan.nextLine();
			System.out.println("Please print last name of Stylist");
			String lastN = scan.nextLine();
			Stylist names = new Stylist();
			names.sfname = firstName;
			names.slname = lastN;
			System.out.println("Entered Stylists into array");
			FillArray(arrStylists, names);
			System.out.println("Inserted Client into Schedule");
			insertIntoSchedule(temp, retrieveFromName(arrStylists, names));
		}
		
		/*Stylist person = new Stylist();
		person.Sinformation();
		System.out.println(person.sfname + " " + person.slname);
		System.out.println(person.schedule);*/
		//Add 
	}
}
