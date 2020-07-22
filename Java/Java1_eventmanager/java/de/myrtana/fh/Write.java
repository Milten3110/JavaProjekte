package de.myrtana.fh;

import java.io.*;

public class Write {
	
	public static void writer(String input, String filegenre)throws IOException
	{	
		try
		{
			String write = input; //Was im txt hinterlegt wird
			String filename = filegenre;
			
			FileWriter fw = new FileWriter(filename); // filename desjeweiligen aufrufs und der Speicherung
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(write);
			bw.close();
		}
		catch(IOException e)
		{
			System.out.println("Error : " + filegenre + " can not write");
		}
	}
}