package db;

import com.fasterxml.jackson.databind.ObjectMapper;
import oop.Event;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Database {

    //Global Class Values
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rstmt = null;

    static String output = "";
    static boolean connOpen = false;

    //Datenbank URL mit Benutzer und Passwort
    static final String dbUrl  = "jdbc:mysql://localhost:3306/Java2DB";
    static final String dbUser = "andy";
    static final String dbPw = "pw";


    //################################################################################################################
    //Java Object To Json
    //################################################################################################################
    public static Event jsonToJavaObject(String jsonString) throws Exception{
        try {
            Event newEvent = new Event();
            String eventElemente[] = new String[10];
            String temp = "";
            int elementCounter = 0;
            int hochkommaCounter = 0;
            boolean canPushBack = false;
            boolean firstElemt = true;

            //JSON String neu Parsen und zu Java
            //14 da die json string erst da anfangen mit eventname
            for(int index = 0; index < jsonString.length(); ++index){

                //Abbruchbedingung
                if(canPushBack){

                    if(jsonString.charAt(index) == '"'){

                        eventElemente[elementCounter] = temp;
                        temp = "";
                        ++ elementCounter;

                        canPushBack = false;
                    }
                    else{
                        temp += jsonString.charAt(index);
                    }
                }

                if(jsonString.charAt(index) == '"'){
                    ++hochkommaCounter;
                }

                if(hochkommaCounter == 3 && firstElemt){
                    canPushBack = true;
                    firstElemt = false;
                    hochkommaCounter = 0;
                }

                if(hochkommaCounter == 2 && !firstElemt) {
                    canPushBack = true;
                    hochkommaCounter = 0;
                }


            }

            //Test ausgabe in der Konsole
            for(int index = 0; index < 3 ; ++index){
                System.out.println(eventElemente[index]);
            }
            System.out.println(jsonString);

            newEvent.setEventName(eventElemente[0]);
            newEvent.setEventOrt(eventElemente[1]);


            return newEvent;
        }
        catch ( Exception e){
            //gibt fehlerhaftes Event zurück
            Event errorEvent = new Event();
            errorEvent.setEventName("FEHLER JSON TO JAVA");
            System.out.println("Fehler : " + e);
            return errorEvent;
        }
    }

    public static String javaObjectToJson(Event writeEvent) throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        try {

            //java object to json file
            //mapper.writeValue(new File("c:\\test.json"), writeEvent);

            //json string
            String jsonString = mapper.writeValueAsString(writeEvent);

            //System.out.println(jsonString);
            return jsonString;
        }

        catch (Exception e){
            System.out.println("fehler beim schreiben der Json datei : // " + e);
            return "fehler beim schreiben der Json datei :"  + e;
        }
    }
    //################################################################################################################

    //################################################################################################################
    //Zum Ausgeben von Daten der Datenbank
    //################################################################################################################
    private static int getNumbersOfAusteller() throws Exception{
        try {
            stmt = conn.createStatement();
            rstmt = stmt.executeQuery("SELECT ID FROM Austeller");
            //zählt die ids hoch
            int idCounter = 0;
            while(rstmt.next()){
                ++idCounter;
            }

            return idCounter;
        }
        catch (Exception e){
            //Wen 0 gesetzt dann ist ein Fehler aufgetreten
            return 0;
        }
    }

    private static int getAllCarsOfTheEvent(int _id) throws Exception{
        try {
            stmt = conn.createStatement();
            rstmt = stmt.executeQuery("SELECT eventID, modelle FROM Austeller");

            //zählt autos aller austeller auf den event
            int carCounter = 0;

            while(rstmt.next()){

                //Abfrage nach den gesuchten EventID
                //wird dann gezählz wie viele autos vorhanden sind mit austellern
                //die auf das event gehen
                if(rstmt.getInt("eventID") == _id ){
                    //addiert die zahl in den modellen
                    carCounter += rstmt.getInt("modelle");
                }

                //ansonsten wird weiter in der Tabelle gesucht

            }


            return carCounter;
        }
        catch (Exception e){
            return 0;
        }
    }

    public static String readEvent(int searchedID) throws Exception{
        try {
            //Sql abfrage ausführen
            //Sql Befehlsobject erstellen
            stmt = conn.createStatement();

            //weist rstmt zu , welche Tabelle betrachtet werden muss
            rstmt = stmt.executeQuery("SELECT * FROM Event");
            for(int index = 0; index < searchedID ; ++index){
                //Rutscht mit den Curser in der Tabelle weiter nach unten um Index
                rstmt.next();
            }

            //Event erstellen und füllen von der Datenbankabfrage
            Event newEvent = new Event();
            newEvent.setEventName(rstmt.getString("eventName"));
            newEvent.setInternEmployee(rstmt.getInt("internEmployee"));
            newEvent.setExternEmployee(rstmt.getInt("externEmployee"));
            //ID zählen von Sql um anzahl von Austellern zu setzen
            newEvent.setAusteller(getNumbersOfAusteller());

            rstmt = stmt.executeQuery("SELECT usageHalle FROM Halle");
            rstmt.next();
            newEvent.setCurrentMaxUsablePlaces(rstmt.getInt("usageHalle"));

            rstmt = stmt.executeQuery("SELECT city FROM Ort");
            rstmt.next();
            newEvent.setEventOrt(rstmt.getString("city"));


            //modelle zählen von austellern
            newEvent.setPiceOfVisibleCars(getAllCarsOfTheEvent(searchedID));


            return javaObjectToJson(newEvent);
        }
        catch (Exception e){
            return "cant read database: " + e;
        }
    }

    //Ruf sollange getEventByID auf bis .next false ist
    public static String getAllEvents(){
        try {
            Statement _stmt = conn.createStatement();
            ResultSet _rstmt = _stmt.executeQuery("SELECT * FROM Event");

            //1 weil die start id 1 ist
            int eventCounter = 1;
            String events = "";

            while(_rstmt.next()){
                events =  events + readEvent(eventCounter) + "\r\n";
                ++ eventCounter;
            }
            return events;
        }
        catch (Exception e){
            return "Error : " + e;
        }
    }

    //################################################################################################################

    //################################################################################################################
    //In Datenbank schreiben
    //################################################################################################################
    public static String writeEventIntoDatabase() throws Exception{
        try {
            String jsonString = readEvent(1);


            return jsonToJavaObject(jsonString).getEventName();

        }
        catch (Exception e){
            System.out.println("Fehler : " + e);
            return "Fehler : " + e;
        }
    }
    //################################################################################################################

    //Important, Init Connection to the Database
    public static boolean createConnection() throws Exception{

        try {
            if(!connOpen){
                //Datenbanktreiber laden
                //Obtional seit JDBC 4
                //Class.forName("org.")
                //old Treiber Class.forName("com.mysql.jdbc.Driver");
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(dbUrl,dbUser,dbPw);
                connOpen = true;
                System.out.println("Verbindung offen");
                return true;
            }
            else{
                System.out.println("Verbindung bereits offen");
                return true;
            }

        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }


    /**
     * Hier geht alles und ist als Backup SPeicher
     * Dies ist getestet und funktioniert einwandfrei !
     *
     * package db;
     *
     * import java.sql.Connection;
     * import java.sql.DriverManager;
     * import java.sql.ResultSet;
     * import java.sql.Statement;
     * import java.util.List;
     *
     * public class Database {
     *
     *     public static boolean createConnection() throws Exception{
     *
     *         try {
     *
     *             //Datenbanktreiber laden
     *             //Obtional seit JDBC 4
     *             //Class.forName("org.")
     *
     *             System.out.println("Treiber Laden");
     *             //Datenbankverbindung herstellen
     *             //old Treiber Class.forName("com.mysql.jdbc.Driver");
     *             Class.forName("com.mysql.cj.jdbc.Driver");
     *
     *             final String dbUrl  = "jdbc:mysql://localhost:3306/Java2DB";
     *
     *             System.out.println("After Connection");
     *
     *             final String dbUser = "andy";
     *             final String dbPw = "pw";
     *
     *
     *             Connection conn = null;
     *             Statement stmt = null;
     *             ResultSet rstmt = null;
     *
     *
     *             System.out.println("Bevor open Connection");
     *             //Verbindung öffnen
     *             conn = DriverManager.getConnection(dbUrl,dbUser,dbPw);
     *
     *             System.out.println("After Connection");
     *
     *             //Sql Befehlsobject erstellen
     *             stmt = conn.createStatement();
     *
     *             System.out.println("Bevor auslesen");
     *
     *             //Sql abfrage ausführen
     *             rstmt = stmt.executeQuery("SELECT * FROM Austeller");
     *             rstmt.next();
     *             System.out.println(rstmt.getInt("ID") + " " + rstmt.getInt("usageHalle")  + " " + rstmt.getInt("period")
     *             + " " + rstmt.getInt("modelle"));
     *
     *             System.out.println("Nach auslesen");
     *
     *
     *
     *
     *
     *             return true;
     *         }
     *         catch (Exception e){
     *             System.out.println(e);
     *             return false;
     *         }
     *     }
     *
     */
}
