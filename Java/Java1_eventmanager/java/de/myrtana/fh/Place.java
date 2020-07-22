package de.myrtana.fh;

import java.io.IOException;


public class Place {
	public static String placCorrect = "true";
	
	private static final String[] bundesland = {
		"Schleswig-Holstein", "Mecklenburg-Vorpommern", "Hamburg",
		"Bremen","Niedersachsen","Brandenburg","Berlin","Sachsen-Anhalt",
		"Nordrhein-Westfalen","Hessen","Thuringen","Sachsen",
		"Rheinland-Pfalz","Saarland","Baden-Wurttemberg","Bayern"
	}; // Fest codierete Ortsbezeichner
	
	private static final String[] hauptstadt = {
		"Kiel", "Schwerin","Hamburg","Bremen","Hannover","Potsdam",
		"Berlin","Magdeburg","Duesseldorf","Wiesbaden","Erfurt",
		"Dresden","Mainz","Saarbrucken","Stuttgart","Munchen"
	};
	
	private static final String[] abkurzungStadt = {
		"ki","sn","hab","hb","h","p","b","md","d","wi","ef","dd","mz", "sb", "s","m"
	};
	
	//abk�rzungen
	/*0 Schleswig-Holstein, Kiel (ki)
	 *1 Mecklenburg-Vorpommern, Schwerin (sn)
	 *2 Hamburg, Hamburg (hab)
	 *3 Bremen, Bremen (hb)
	 *4 Niedersachsen, Hannover (h)
	 *5 Brandenburg, Potsdam (p)
	 *6 Berlin, Berlin (b)
	 *7 Sachsen-Anhalt, Magdeburg (md)
	 *8 Nordrhein-Westfalen,Duesseldorf (d)
	 *9 Hessen, Wiesbaden (wi)
	 *10Thuringen, Erfurt (ef)
	 *11Sachsen, Dresden (dd)
	 *12Rheinland-Pfalz, Mainz (mz)
	 *13Saarland, Saarbrucken (sb)
	 *14Baden-Wurtenberg,Stuttgart (s)
	 *15Bayern, Munchen (m)
	 */
	
	//Abfrage des Ortes und ausgabe der Stadt
	public static void ortAbfrage(String input) throws IOException
	{
//abfrage vom imput 
		
		if (input.equalsIgnoreCase("ki") || input.equalsIgnoreCase("kiel"))
		{
			//System.out.println(bundesland[0]);
			input = hauptstadt[0] + " , " + bundesland[0];
			writePlace(input);
		}
		
		else if(input.equalsIgnoreCase("sn")|| input.equalsIgnoreCase("schwerin"))
		{
			//System.out.println(bundesland[1]);
			input = hauptstadt[1] + " , " + bundesland[1];
			writePlace(input);
		}
		
		else if(input.equalsIgnoreCase("hab")|| input.equalsIgnoreCase("hamburg"))
		{
			//System.out.println(bundesland[2]);
			input = hauptstadt[2] + " , " + bundesland[2];
			writePlace(input);
		}
		
		else if(input.equalsIgnoreCase("hb")|| input.equalsIgnoreCase("bremen"))
		{
			//System.out.println(bundesland[3]);
			input = hauptstadt[3] + " , " + bundesland[3];
			writePlace(input);
		}
		
		else if(input.equalsIgnoreCase("h")|| input.equalsIgnoreCase("hannover"))
		{
			//System.out.println(bundesland[4]);
			input = hauptstadt[4] + " , " + bundesland[4];
			writePlace(input);
		}
		
		else if(input.equalsIgnoreCase("p")|| input.equalsIgnoreCase("potsdam"))
		{
			//System.out.println(bundesland[5]);
			input = hauptstadt[5] + " , " + bundesland[5];
			writePlace(input);
		}
		
		else if(input.equalsIgnoreCase("b")|| input.equalsIgnoreCase("berlin"))
		{
			//System.out.println(bundesland[6]);
			input = hauptstadt[6] + " , " + bundesland[6];
			writePlace(input);
		}
		
		else if(input.equalsIgnoreCase("md")|| input.equalsIgnoreCase("magdeburg"))
		{
			//System.out.println(bundesland[7]);
			input = hauptstadt[7] + " , " + bundesland[7];
			writePlace(input);
		}
		
		else if(input.equalsIgnoreCase("d")|| input.equalsIgnoreCase("dusseldorf"))
		{
			//System.out.println(bundesland[8]);
			input = hauptstadt[8] + " , " + bundesland[8];
			writePlace(input);
		}
		
		else if(input.equalsIgnoreCase("wi")|| input.equalsIgnoreCase("wiesbaden"))
		{
			//System.out.println(bundesland[9]);
			input = hauptstadt[9] + " , " + bundesland[9];
			writePlace(input);
		}
		
		else if(input.equalsIgnoreCase("ef")|| input.equalsIgnoreCase("erfurt"))
		{
			//System.out.println(bundesland[10]);
			input = hauptstadt[10] + " , " + bundesland[10];
			writePlace(input);
		}
		
		else if(input.equalsIgnoreCase("dd")|| input.equalsIgnoreCase("dresden"))
		{
			//System.out.println(bundesland[11]);
			input = hauptstadt[11] + " , " + bundesland[11];
			writePlace(input);
		}
		
		else if(input.equalsIgnoreCase("mz")|| input.equalsIgnoreCase("mainz"))
		{
			//System.out.println(bundesland[12]);
			input = hauptstadt[12] + " , " + bundesland[12];
			writePlace(input);
		}
		
		else if(input.equalsIgnoreCase("sb")|| input.equalsIgnoreCase("saarbrucken"))
		{
			//System.out.println(bundesland[13]);
			input = hauptstadt[13] + " , " + bundesland[13];
			writePlace(input);
		}
		
		else if(input.equalsIgnoreCase("s")|| input.equalsIgnoreCase("stuttgart"))
		{
			//System.out.println(bundesland[14]);
			input = hauptstadt[14] + " , " + bundesland[14];
			writePlace(input);
		}
		
		else if(input.equalsIgnoreCase("m")|| input.equalsIgnoreCase("munchen"))
		{
			//System.out.println(bundesland[15]);
			input = hauptstadt[15] + " , " + bundesland[15];
			writePlace(input);
		}
		else
		{
			System.out.println("Unbekannte eingabe..");
			placCorrect = "false";
		}
	}
	
	//Writer aufrufen und übergabe der Stadt
	public static void writePlace(String input)
	{
		try
		{
			Main.eventAttributZwischenSpeicher[1] = input; //Ort wird zwischen gespeichert
			Write.writer(input, GlobalClass.lists[2]);
		}
		catch(IOException e)
		{
			System.out.println("Error: " + e.getMessage()); //Ausgabe des fehlers 
		}
	}
	
	
	public static void createOrt(String input) throws IOException
	{
		ortAbfrage(input);
		
	}
}
