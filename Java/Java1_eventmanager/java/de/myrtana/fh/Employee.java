package de.myrtana.fh;

import java.io.IOException;


public class Employee 
{
	public static String internAndExternEmployeeInput = "false";
	
	public static void createEmployee(String employee) throws IOException
	{
		//de.myrtana.fh.Employee erste zeile intern, 2 extern
		String employeeSplit = "";
		for (int i = 0; i < employee.length(); ++ i)
		{
			if(employee.charAt(i) == ',')
			{
				employeeSplit = employeeSplit + "\r\n";
				internAndExternEmployeeInput = "true";
			}
			else
				employeeSplit = employeeSplit + employee.charAt(i);
		}
		
		try
		{
			Write.writer(employeeSplit, GlobalClass.lists[1]);
		}
		catch(IOException e)
		{
			System.out.println("Error : " + e.getMessage());
		}
	}
}
