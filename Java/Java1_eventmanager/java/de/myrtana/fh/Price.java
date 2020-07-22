package de.myrtana.fh;

import java.io.IOException;

public class Price {
	public static void createPriceList() throws IOException
	{
		//Autonamen und dazugeh�rigen Preise 19 Autotypen
		String[] carName = 
		{"A1","A3", "A4", "A5", "A6", "A7", "A8", "Q1", "Q3", "Q5", "Q6", "Q7", "Q8", "Q9", "TT", 
				"RS", "R8", "E-Tron", "G-Tron"};
		
		String[] carsPrice = 
		{"12999","16999", "27999", "36799", "41999", "45899", "69999", "18999", "21999", "31999", "39799", "55999", "678999", "91999", "39999", 
				"99999", "218999", "112999", "136999"};
		
		String goWriter = ""; //die �berf�hrung an den Writer
		for(int i = 0; i < 19 ; i++)
		{
			goWriter += i + ". " + carName[i] + " " + carsPrice[i] + "\r\n";
		}
		
		try
		{
			Write.writer(goWriter, GlobalClass.lists[3]);
		}
		catch(IOException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
}
