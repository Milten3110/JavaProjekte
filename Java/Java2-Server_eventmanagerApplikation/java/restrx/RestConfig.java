package restrx;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//Hier kommt der pfad rein wo die folgenden klassen
//erreichbar sind
@ApplicationPath("api")
//application aus den Cor nehmen
public class RestConfig extends Application {

    @Override
    public Set<Class<?>> getClasses(){

        Set<Class<?>> classes = new HashSet<>();

        //Klassen hinzufügen um angesteuert zu werden
        classes.add(GetEventByID.class);
        classes.add(GetAllEvents.class);
        classes.add(CreateNewEvent.class);



        return classes;
    }
}
