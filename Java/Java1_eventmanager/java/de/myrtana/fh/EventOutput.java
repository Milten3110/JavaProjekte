package de.myrtana.fh;

import java.io.IOException;

public class EventOutput {
		
	public static void readEvent() throws IOException
	{
		int missingFileCount = 0;
		try
		{
			
			for(int count = 0; count < 4; ++ count) // pricelist ignore
			{
				if(count == 10)
				{
					++ missingFileCount;
				}
				else
				{
					Read.reader(GlobalClass.readList[missingFileCount]);
					++ missingFileCount;
				}
				 
			}
			
	
		}
		catch(IOException e)
		{
			System.out.println("Read Error: missing file " + GlobalClass.readList[missingFileCount]);
			Price.createPriceList();
			System.out.println("Mistake is corrected, pls restart!");
		}
	}
}
