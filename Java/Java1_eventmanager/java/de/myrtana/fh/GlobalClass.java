package de.myrtana.fh;

public class GlobalClass {
	
	//Liste der Notwendigen Daten, 5
	// 0 = AutoKontigent.txt
	// 1 = Mitarbeiter.txt
	// 2 = Ort.txt
	// 3 = Preisliste.txt
	// 4 = Veranstaltungen.txt
		public static final String[] lists = {"de.myrtana.fh.Warehouse.txt","de.myrtana.fh.Employee.txt","de.myrtana.fh.Place.txt",
			"Pricelist.txt","oop.Event.txt"};
		
		public static final String[] junitList = {"de.myrtana.fh.Warehouse.txt","de.myrtana.fh.Employee.txt","de.myrtana.fh.Place.txt",
				"oop.Event.txt"}; //String for Junit testing
		
		public static final String[] readList = {
				"oop.Event.txt","de.myrtana.fh.Place.txt","de.myrtana.fh.Employee.txt","de.myrtana.fh.Warehouse.txt","Pricelist.txt"};
		
		public static final int inputCharacterRule = 4; // eingabe 4x < vorhanden ?
}
