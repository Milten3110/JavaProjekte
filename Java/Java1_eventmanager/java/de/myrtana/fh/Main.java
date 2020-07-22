package de.myrtana.fh;

import java.io.IOException;
import java.util.Scanner;
import oop.*;

import javax.print.DocFlavor;


public class Main {
	
	public static String  inputRuleRight = "false"; //Controll Value
	public static String  eventReadWriteQuery = "false"; // Controll Value
	public static String readInput = "";

	//Event Attribut Speicherung
	private static int eventAttributZwischenSpeicherMaxIndex = 5;
	public static String[]  eventAttributZwischenSpeicher = new String[eventAttributZwischenSpeicherMaxIndex]; //Atribute von Event
	
	private static void createEvent(String input)
	{
		try
		{
			EventCreate.createVeranstaltung(input);
		}
		catch(IOException x)
		{
			System.out.println("Error: oop.Event can not be created");
		}
	}
	
	private static void readEvent()
	{
		try 
		{
			EventOutput.readEvent();
		}
		catch (IOException e)
		{
			System.out.println("Error: This program can not communicate with other classes and methods" );
		}

		//eventReadToOop(); //Event() wird gefüllt mit den Daten in den Txt
	}
	
	
	public static void inputQuery(String inputQuery) //query if 4x '<' 
	{
		int queryCount = 0;
		try
		{
			for(int i = 0; queryCount < GlobalClass.inputCharacterRule; ++i)
			{
				if(inputQuery.charAt(i) == '<')
				{
					++ queryCount;
				}			
			}
			inputRuleRight = "true";
		}
		catch(Exception e)
		{
			
			System.out.println("Error: You have forgotten at least " + (GlobalClass.inputCharacterRule - queryCount )+ " '<' "); //Error output
		}
		
	}
	
	
	public static void inputScanner() //Input from User
	{
		String input = "";
		System.out.println("Name<Ort<employeeIn,ex<model-pic<");
		Scanner s = new Scanner(System.in);//Input Scanner
		input = s.nextLine(); // muss raus bei junit , konsole verboten //
		s.close();

		inputQuery(input); // unit test, input wird überschreiben
		createEvent(input);

	}



	public static void rAndWInputFunctionForJunit(String rAndWInputstring)
	{
		switch (rAndWInputstring)
		{
			case "w":
				eventReadWriteQuery = "true";
				//inputScanner(); // zum ausführen von create event, auslagern wegen j unit
				break;
			case "r":
				eventReadWriteQuery = "true";
				//readEvent(); //zum lesen eines events
				break;
			default:
				System.out.println("Falsche Eingabe");
				break;
		}
	}

	public static void eventReadToOop() throws IOException
	{
		try {
			//OopEvent Ausgeben
			//dazu wird ein pseudoEvent erstellt
			Event event01 = new Event();

			Read.reader("oop.Event.txt");
			eventAttributZwischenSpeicher[0] = readInput;
			event01.setEventname(eventAttributZwischenSpeicher[0]);
			//eventAttributZwischenSpeicher[0] = readInput;
			Read.reader("de.myrtana.fh.Place.txt");
			eventAttributZwischenSpeicher[1] = readInput;
			event01.setOrt(eventAttributZwischenSpeicher[1]);
			//eventAttributZwischenSpeicher[1] = readInput;
			Read.reader("de.myrtana.fh.Employee.txt");
			eventAttributZwischenSpeicher[2] = readInput;
			event01.setEmployee(eventAttributZwischenSpeicher[2]);
			//eventAttributZwischenSpeicher[2] = readInput;


		}
		catch( Exception e ){
			System.out.println("Fehler beim auslesen der Datein!");
		}
	}

	public static void eventCreatToOop()
	{

	}

	public static void main(String args[]) throws IOException
	{

		String readWrite = "";
		System.out.println("Read event:r \r\nWrite event:w");
		Scanner rw = new Scanner(System.in);
		readWrite = rw.nextLine();


		rAndWInputFunctionForJunit(readWrite);

		switch (readWrite)
		{
			case "w":
				inputScanner(); // zum ausführen von create event, auslagern wegen j unit
				rw.close(); // muss nach der funktion geschlossen werden, sonst fehler
				break;
			case "r":
				readEvent(); //zum lesen eines events
				rw.close();
				eventReadToOop();
				break;
			default:
				System.out.println("Falsche Eingabe");
				break;
		}


/*
		//Event erstellen
		Event event01 = new Event();
		event01.setEventname(eventAttributZwischenSpeicher[0]);
		event01.setOrt(eventAttributZwischenSpeicher[1]);
		event01.setEmployee(eventAttributZwischenSpeicher[2]);

		System.out.println("\r\nich werde ausgführt.");
		System.out.println("\r\n");
		System.out.println(event01.getPiceOfVisibleCars());
		System.out.println(event01.getEmployee());
		System.out.println(event01.getExternEmployee());
		System.out.println(event01.getInternEmployee());
		System.out.println(event01.getEventName());
*/

		//Event event02 = new Event();
		//Autos in den Speicherladen von Txt
		//Read.reader("de.myrtana.fh.Warehouse.txt");
		//eventAttributZwischenSpeicher[3] = readInput;
		//System.out.println(eventAttributZwischenSpeicher[3]);
		//event02.setTheVisibleCarValue(eventAttributZwischenSpeicher[3]);

		//Ausgabe
		//System.out.println(event02.getPiceOfVisibleCars());

	}
}
