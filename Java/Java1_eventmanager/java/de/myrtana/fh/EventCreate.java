package de.myrtana.fh;

import java.io.IOException;

public class EventCreate 
{
	
	public static void createEventKomponent(int switchNumber, String splitInput) throws IOException //call function from spezifikate variables
	{
		try
		{
			//Event event01 = new Event();
			switch(switchNumber){
	        case 1:
				//event01.name = splitInput;  x
				Main.eventAttributZwischenSpeicher[0] = splitInput;
	            //System.out.println("Das ist der Name des Events : " + splitInput );
	            EventName.createName(splitInput);
	            break;
	        case 2:
				//event01.setOrt(splitInput);
				//de.myrtana.fh.Main.eventAttributZwischenSpeicher[1] = splitInput; x
	            //System.out.println("Das ist der Ort des Events : " + splitInput);
	            Place.createOrt(splitInput);
	            break;
	        case 3:
				//event01.setEmployee(splitInput);
				Main.eventAttributZwischenSpeicher[2] = splitInput;
	            //System.out.println("Das sind die Anzahl der Intern und Extern Mitarbeiter : " + splitInput);
	            Employee.createEmployee(splitInput);
	            break;
	        case 4:
				//event01.setTheVisibleCarValue(splitInput);
				Main.eventAttributZwischenSpeicher[3] = splitInput;
	            //System.out.println("Das sind die Autos auf dem oop.Event : " + splitInput);
	            Warehouse.createKontigent(splitInput);
	            break;
	        default:
	            System.out.println("Zu viele eingabe");
	        } 
		}
		catch(IOException e)
		{
			
		}
		
	}
	
	public static void splitTheStringInTheCategorie(String input) throws IOException // split the string in categories
	{
		int i = 1;
		int splitCounter = 0;
		int forCounter = 0;
		while(i > 0)
		{
			
			String inputWriter = "";
			for(int a = 0; input.charAt(splitCounter) != '<' ; ++a)
			{
				inputWriter = inputWriter + input.charAt(splitCounter);
				++ splitCounter; 
			}
			++ splitCounter;
			++ forCounter;
			createEventKomponent(forCounter, inputWriter);
			
			++ i;
			//break condision
			if(i == 5) // 5 hard condision 
			{
				i = 0;
				//System.out.println("Test erfolgreich !!");
			}
		} 
	}
	
	//Hauptklasse die Parameter annimt 
	public static void createVeranstaltung(String input) throws IOException
	{
		splitTheStringInTheCategorie(input);
	}
}


