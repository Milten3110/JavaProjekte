package oop;

public class Event {

    private String eventName = "nonne";
    private String eventOrt = "nonne";
    private int piceOfVisibleCars = 0; //stück der zu sehenden autos
    private int internEmployee = 0;
    private int externEmployee = 0;
    private int austeller = 0; //wie viele austeller auf der messe sind
    private int currentMaxUsablePlaces = 0; //maximale freie fläche die zu vergeben ist

    //Junit Testfälle
    public boolean ifEmployeeSet = false;
    public boolean ifInternEmployeeSet = false;
    public boolean ifExternEmployeeSet = false;
    public boolean ifEventNameSet = false;
    public boolean ifEventOrtSet = false;
    public boolean ifEventCreadet = false;

    //Event Ort Gesetzt ?
    private void jIfSetOrt(){
        if(eventOrt != "nonne"){
            ifEventOrtSet = true;
        }
    }
    //Event Name Gesetzt ?
    private void jIfSetName(){
        if(eventName != "nonne"){
            ifEventNameSet = true;
        }
    }

    //Employee, Intern Extern gesetzt ?
    private void jIfSetEmployee(){
        if (internEmployee != 0){
            ifInternEmployeeSet = true;
        }
        if(externEmployee != 0){
            ifExternEmployeeSet = true;
        }
        if(ifExternEmployeeSet == true && ifInternEmployeeSet == true){
            ifExternEmployeeSet = true;
        }

    }

    //Employee Function Externe mitarbeiter
    private void splitEmployeeToInternAndExternEmployee(String inputEmployee){
        //split employee
        String employeeSplitIntern = "";
        String employeeSplitExtern = "";

        //Kompliziertes Spalten des Strings in einzelne
        for (int i = 0; i < inputEmployee.length(); ++ i)
        {
            if(inputEmployee.charAt(i) == ',')
            {
                int stringToInt = Integer.parseInt(employeeSplitIntern);
                setInternEmployee(stringToInt);
                ++ i; // i = 2
                for(int index = inputEmployee.length() -  i; index >= 0 ; --index){
                    if(inputEmployee.charAt(index) == '<'){
                        employeeSplitExtern = employeeSplitExtern + inputEmployee.charAt(i);
                        i = 0; //break bedingung
                    }

                    employeeSplitExtern = employeeSplitExtern + inputEmployee.charAt(i);
                    -- index;
                    System.out.println(employeeSplitExtern);
                }
                stringToInt = Integer.parseInt(employeeSplitExtern);
                setExternEmployee(stringToInt);
            }
            else
                employeeSplitIntern = employeeSplitIntern + inputEmployee.charAt(i);
        }
        jIfSetEmployee();
    }

    //Visible Cars
    public void setTheVisibleCarValue(String carsInTheEvent){
        //Controll Value
        String speicher = "";
        int currentPiceOfCarsInTheEvent = 0;

        for(int i = 0; i < carsInTheEvent.length(); ++i){

            //Abfrage ab wan die stückzahl beginnt
            if(carsInTheEvent.charAt(i) == '-')
            {
                //um nach dem - zu sein
                ++ i;
                //Speichern der zahlen nach den - bis zum nächsten oder ende des Strings
                //in hat den index wert von i damit der String nur einmal durchgelesen wird
                for(int in = i; in <= carsInTheEvent.length(); ++ in)
                {
                    //Abfrage ob mehrere autotypen sind und getrennt sind
                    //werden nun zussammen gerechnet
                    if(carsInTheEvent.charAt(in) == ',')
                    {
                        //I auf den zählerstand von in setzen um dort weiter zu parsen
                        i = in;
                        //Abbruchbeding um das zählen von anfang an zu machen
                        in = carsInTheEvent.length();
                        currentPiceOfCarsInTheEvent = Integer.parseInt(speicher);
                    }
                    else{
                        speicher = speicher + carsInTheEvent.charAt(i);
                    }
                }



            }

        }
    }

    //getFunction
    public String getEventName(){return eventName;}
    public int getPiceOfVisibleCars(){return piceOfVisibleCars;}
    public int getEmployee(){return externEmployee+internEmployee;}
    public int getInternEmployee(){return internEmployee;}
    public int getExternEmployee(){return externEmployee;}
    public int getAusteller(){return austeller;}
    public int getCurrentMaxUsablePlaces() {return currentMaxUsablePlaces;}

    //setFunction
    private void setInternEmployee(int newInternEmployee){internEmployee = newInternEmployee;}
    private void setExternEmployee(int newExternEmployee){externEmployee = newExternEmployee;}

    //public void setPiceOfVisibleCars(String inputCars){setTheVisibleCarValue(inputCars);} Fehlerstellung ??
    private void setPiceOfVisibleCars(int currentVisibaleCars){piceOfVisibleCars = currentVisibaleCars;}
    public void setEmployee(String inputEmployee){splitEmployeeToInternAndExternEmployee(inputEmployee);}
    public void setAusteller(int newAusteller){austeller = newAusteller;}
    public void setCurrentMaxUsablePlaces(int newCurrentMaxUsablePlaces){currentMaxUsablePlaces = newCurrentMaxUsablePlaces;}
    public void setOrt(String newOrt){eventOrt = newOrt; jIfSetOrt();}
    public void setEventname(String newEventName){eventName = newEventName; jIfSetName();}
    public void setInternEmployeeForTestting(int newInternEmployee){internEmployee = newInternEmployee;}
}
