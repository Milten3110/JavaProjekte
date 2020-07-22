package ownJPA;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MyEntitiyClass {

    //Primary Key
    @Id
    @GeneratedValue(strategy =//Primärschlüssel automatisch vergeben
            GenerationType.IDENTITY)
    private Long id;

    //Versionskontrolle
    @Version
    private Long version;

    //temporärer speicher, der den zeitstämpel abspeichert bei erstellung
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    //@Transient für nicht persistente werte


    //
    public MyEntitiyClass(){
        //this( "unknow" , "unknow");
    }

    //Beziehungen der Entitys
    //@OneToMeny event to hall
    //@OneToMany  hall to area
    //@OneToMany hall to austeller
    //@OneToOne hall to ort
    //@ManyToOne austeller to modelle


}
