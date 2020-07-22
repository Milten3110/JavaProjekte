package de.myrtana.fh;

import java.io.IOException;


public class Warehouse {
	
	
	
	public static void createCar(String[] create)throws IOException
	{
		String carWrite = "";
		for(int i = 0; i < 10;i ++)
		{
			if(create[i] != null)
			{
				//System.out.println(create[i]);
				carWrite = carWrite + create[i];
				carWrite = carWrite + "\r\n"; // Zeilenumbruch 
			}
		}
		
		try
		{
			Write.writer(carWrite, GlobalClass.lists[0]); // see de.myrtana.fh.GlobalClass
		}
		catch(IOException e)
		{
			System.out.println("Write Error: " + GlobalClass.lists[0] + " , can not be createt");
		}
		
		//System.out.println(carWrite);
	}
	
	
	public static void createKontigent (String cars)throws IOException
	{
		String[] carSave = new String[10]; //ArrayDefinieren , 10 autosmax 
		
		//welche art von Autos sind auf der Messe und welche Stueckzahl
		
		//parsen des Strings 
		/*
		 * ',' ist die abgrenzung neuer autos
		 *  '-' ist die dazugehoerige stueckzahl der autos 
		 */
		
		//System.out.println(cars + "\r\n" + cars);
		
		//Zerlegung des Strings von unoetigen Zeichen 
		String generateCar = "";
		int countOfString = 0;
		cars += "e";
		//System.out.println(cars);
		for(int i = 0;i < cars.length(); ++ i)
		{
			if(cars.charAt(i) == ',')
			{
				carSave[countOfString] = generateCar;
				generateCar = "";
				++ countOfString;
				
				//System.out.println("");
			}
			else if(cars.charAt(i) == 'e') // endbestimmung des Strings 
			{
				carSave[countOfString] = generateCar;
			}
			else
			{
				generateCar += cars.charAt(i); // Speichern des einzel wertes
				//System.out.println(generateCar);
				//System.out.println(cars.charAt(i)); //ausgabe des chars an den wert 
			}
		}

		Warehouse.createCar(carSave);
	}
}
