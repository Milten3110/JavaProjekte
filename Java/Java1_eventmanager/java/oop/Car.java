package oop;

public class Car {
    //Function -> Public
    public double price;
    public int ps;

    //Junit Value
    public boolean ifCarCreadet = false;
    public boolean ifSetKmH = false;
    public boolean ifSetCunstructionYear = false;
    public boolean ifSetAdmissionYear = false;
    public boolean ifSetIncHolder = false;
    public boolean ifSetMaxSpeed = false;

    //setFunction
    public void setKmh(double newKmH) {
        currentKmh = newKmH;
        ifSetKmH = true;
    };
    public void setCunstructionYear(String newCunstructionYear){
        cunstructionYear = newCunstructionYear;
        ifSetCunstructionYear = true;
    }
    public void setAdmissionYear(String newAdmissionYear){
        admissionYear = newAdmissionYear;
        ifSetAdmissionYear = true;
    }
    public void setIncHolder(){
        holder = holder + 1;
        ifSetIncHolder = true;
    }
    public void setMaxSpeed(int newMaxSpeed){maxSpeed = newMaxSpeed; ifSetMaxSpeed = true;}

    //getFunction
    public double getCurrentKmh(){
        return currentKmh;
    }
    public String getCunstructionYear(){
        return cunstructionYear;
    }
    public String getAdmissionYear(){
        return admissionYear;
    }
    public int getHolder(){
        return holder;
    }
    public int getMaxSpeed(){return maxSpeed;}

    //Private
    private int maxSpeed = 0; //maximale geschwindigkeit des car's
    private double currentKmh = 0.0; //aktuelle kilometer zähler
    private String cunstructionYear = "01.2019";
    private String admissionYear = "01.2019"; //zulassungsmonat/zulassungsjahr
    private int holder = 0; //car holders
}
