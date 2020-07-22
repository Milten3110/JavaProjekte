package de.myrtana.fh;

import java.io.IOException;


public class EventName {
	public static void createName(String eventName)throws IOException
	{
		try
		{
			Write.writer(eventName, GlobalClass.lists[4]);
		}
		catch(IOException e)
		{
			System.out.println("Error : can not be created " + GlobalClass.lists[4]);
		}		
	}
}
