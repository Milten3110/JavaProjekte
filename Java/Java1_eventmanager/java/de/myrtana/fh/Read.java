package de.myrtana.fh;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Read {
	public static String pricelistCreated = "false"; // control value 
	
	public static void reader(String filename)throws IOException
	{
		String readOut = "";
		
		try
		{
			FileReader fr = new FileReader(filename); // name des zu lesenden Dokuments
			BufferedReader br = new BufferedReader(fr);
			
			//End of line
				int countEnd = -1;
				for(int i = 0; i != countEnd; i++)
				{
					readOut = br.readLine();
					if(readOut == null)
					{
						//zeile = i;
						countEnd = i+1;
					}

					if (readOut != null)
					{
						//OOP Variante
						Main.readInput = readOut;
						//Old Function
						//System.out.println(readOut);
					}
				}
			//**Ende**	
			pricelistCreated = "true";
			br.close();
		}
		catch(IOException e)
		{
			//Priceliste fehlt, erzeugt hier ein fehler 
			System.out.println("Error : " + e.getMessage());
			Price.createPriceList();
			pricelistCreated = "true";
			System.out.println("Pricelist is creadet!");
		}
		
	}
}
